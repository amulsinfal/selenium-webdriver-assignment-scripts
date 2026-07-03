package assignments;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment16_Open10Tab {
	@Test
	public void testLaunch10Tabs() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		Thread.sleep(2000);
		String actualTitle = driver.getTitle();
		System.out.println("Parent page title: " + actualTitle);
		System.out.println("Opening 10 Tab with facebook");
		for (int i = 1; i <= 10; i++) {
			WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);
			newTab.get("https://www.facebook.com");
			System.out.println("Tab " + i + " - Page Title: " + newTab.getTitle());
		}
		System.out.println("Total tabs open: " + driver.getWindowHandles().size());
		driver.quit();
	}
}