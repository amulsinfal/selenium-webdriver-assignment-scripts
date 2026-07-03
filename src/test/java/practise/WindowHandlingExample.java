package practise;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import utilities.ElementUtils;

public class WindowHandlingExample {

	@Test
	public void testWindowSwitch() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		String expectedURL = "https://formy-project.herokuapp.com/switch-window";
		String actualURL = driver.getCurrentUrl();
		System.out.println("Parent page url: " + actualURL);
		if (actualURL.equals(expectedURL)) {
			System.out.println("Parent page url is correct - Test Passed");
		} else {
			System.out.println("Parent page url is incorrect - Test Failed");
		}
		Thread.sleep(3000);
		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent window Id: " + parentWindowId);
		driver.findElement(By.id("new-tab-button")).click();
		Thread.sleep(3000);
		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println("All window Id: " + allWindowsId);
		String switchedChildId = null;
		for(String childId : allWindowsId) {
			if(!childId.equals(parentWindowId)) {
				System.out.println("Switched to child window with id " + childId);
				switchedChildId = childId;
				driver.switchTo().window(childId);
			}
		}
		driver.findElement(By.linkText("Checkbox")).click();
		expectedURL = "https://formy-project.herokuapp.com/";
		actualURL = driver.getCurrentUrl();
		System.out.println("Child page url: " + actualURL);
		if (actualURL.equals(expectedURL)) {
			System.out.println("Child page url is correct - Test Passed");
		} else {
			System.out.println("Child page url is incorrect - Test Failed");
		}
		Thread.sleep(3000);
		driver.close();
		System.out.println("Child window with id " + switchedChildId + " closed.");
		driver.switchTo().window(parentWindowId);
		expectedURL = "https://formy-project.herokuapp.com/switch-window";
		actualURL = driver.getCurrentUrl();
		System.out.println("Parent page url: " + actualURL);
		if (actualURL.equals(expectedURL)) {
			System.out.println("Parent page url is correct - Test Passed");
		} else {
			System.out.println("Parent page url is incorrect - Test Failed");
		}
		Thread.sleep(3000);

		driver.quit();
	}
	
	@Test
	public void testWindowSwitchToChild() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		String expectedURL = "https://formy-project.herokuapp.com/switch-window";
		String actualURL = driver.getCurrentUrl();
		System.out.println("Parent page url: " + actualURL);
		if (actualURL.equals(expectedURL)) {
			System.out.println("Parent page url is correct - Test Passed");
		} else {
			System.out.println("Parent page url is incorrect - Test Failed");
		}
		Thread.sleep(3000);
		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent window Id: " + parentWindowId);
		driver.findElement(By.id("new-tab-button")).click();
		Thread.sleep(3000);
		Set<String> allWindowsId = driver.getWindowHandles();
		System.out.println("All window Id: " + allWindowsId);
		String switchedChildId = null;
		ElementUtils.switchToWindow(driver, allWindowsId, parentWindowId);
		driver.findElement(By.linkText("Checkbox")).click();
		expectedURL = "https://formy-project.herokuapp.com/";
		actualURL = driver.getCurrentUrl();
		System.out.println("Child page url: " + actualURL);
		if (actualURL.equals(expectedURL)) {
			System.out.println("Child page url is correct - Test Passed");
		} else {
			System.out.println("Child page url is incorrect - Test Failed");
		}
		Thread.sleep(3000);
		driver.close();
		System.out.println("Child window with id " + switchedChildId + " closed.");
		ElementUtils.switchToWindow(driver, parentWindowId);
		expectedURL = "https://formy-project.herokuapp.com/switch-window";
		actualURL = driver.getCurrentUrl();
		System.out.println("Parent page url: " + actualURL);
		if (actualURL.equals(expectedURL)) {
			System.out.println("Parent page url is correct - Test Passed");
		} else {
			System.out.println("Parent page url is incorrect - Test Failed");
		}
		Thread.sleep(3000);

		driver.quit();
	}
	
	@Test
	public void switchMulitpleWindows() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		String parentWindowId = driver.getWindowHandle();
		System.out.println("Parent window Id: " + parentWindowId);
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a[@href]"));
		
		for(WebElement link : allLinks) {
			link.click();
		}
		
		Set<String> allWindowIds = driver.getWindowHandles();
		System.out.println(allWindowIds);
		
		List<String> allWindowIdsList = new ArrayList<String>(allWindowIds);
		
		for(String cid: allWindowIdsList) {
			String cPageTitle = driver.switchTo().window(cid).getTitle();
			if(cPageTitle.contains("YouTube")) {
				driver.switchTo().window(cid);
			}
		}
		
		Thread.sleep(3000);
		driver.quit();
	}
}
