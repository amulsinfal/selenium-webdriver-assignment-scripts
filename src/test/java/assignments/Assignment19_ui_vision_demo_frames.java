package assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment19_ui_vision_demo_frames {

	@Test
	public void testToSwitchToNewTab() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://ui.vision/demo/webtest/frames/");
		// Switching to Parent frame
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Text inside Frame 1");
		Thread.sleep(2000);
		// Switch to main page
		driver.switchTo().defaultContent();
		// Switch to frame 2
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_2.html']")));
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Text inside Frame 2");
		Thread.sleep(2000);
		// Switch to main page
		driver.switchTo().defaultContent();
		// Switch to frame 3
		driver.switchTo().frame(2);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Text inside Frame 3");
		Thread.sleep(2000);
		// Switch to nested frame in frame 3
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
		driver.findElement(By.xpath("//div[@id='i9']")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("i24")).click();
		Thread.sleep(2000);
		// Switching back to parent frame which is frame 32
		driver.switchTo().parentFrame();
		driver.findElement(By.xpath("//input[@name='mytext3']")).clear();
		Thread.sleep(2000);
		// Switch to main page
		driver.switchTo().defaultContent();
		// Switch to nested frame in frame 3
		driver.switchTo().frame(3);
		driver.findElement(By.xpath("//input[@name='mytext4']")).sendKeys("Text inside Frame 4");
		Thread.sleep(2000);
		// Switch to main page
		driver.switchTo().defaultContent();
		driver.quit();
	}
}