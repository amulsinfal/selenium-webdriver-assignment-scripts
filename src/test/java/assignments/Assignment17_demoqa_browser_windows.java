package assignments;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ElementUtils;
public class Assignment17_demoqa_browser_windows {
	@Test
	public void testToSwitchToNewTab() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(2000);
		System.out.println("Current page url: " + driver.getCurrentUrl());
		String parentId = driver.getWindowHandle();
		WebElement newTabElement = driver.findElement(By.id("tabButton"));
		newTabElement.click();
		Set<String> allWindowIds = driver.getWindowHandles();
 		ElementUtils.switchToWindow(driver, allWindowIds, parentId);
 		Thread.sleep(3000);
 		String newTabUrl= driver.getCurrentUrl();
 		System.out.println("New tab url: " + newTabUrl);
		driver.quit();
	}
	@Test
	public void testToSwitchToNewWindow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(2000);
		System.out.println("Current page url: " + driver.getCurrentUrl());
		WebElement newWindowElement = driver.findElement(By.id("windowButton"));
		newWindowElement.click();
		String parentId = driver.getWindowHandle();
		Set<String> allWindowIds = driver.getWindowHandles();
 		ElementUtils.switchToWindow(driver, allWindowIds, parentId);
 		Thread.sleep(3000);
 		String newWindowUrl= driver.getCurrentUrl();
 		System.out.println("New window url: " + newWindowUrl);
 		driver.close();
 		Thread.sleep(3000);
		driver.quit();
	}
	@Test
	public void testToSwitchToNewMessageWindow() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/browser-windows");
		Thread.sleep(2000);
		System.out.println("Current page url: " + driver.getCurrentUrl());
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
		WebElement newMessageWindowElement = driver.findElement(By.id("messageWindowButton"));
		newMessageWindowElement.click();
		Thread.sleep(3000);
		Set<String> allWindowIds = driver.getWindowHandles();
		System.out.println(allWindowIds);
 		ElementUtils.switchToWindow(driver, allWindowIds, parentId);
 		Thread.sleep(3000);
 		String bodyText = driver.findElement(By.tagName("body")).getText();
        System.out.println("New window content: " + bodyText);
 		driver.close();
 		Thread.sleep(3000);
 		driver.switchTo().window(parentId);
 		Thread.sleep(3000);
		driver.quit();
	}
	
}
