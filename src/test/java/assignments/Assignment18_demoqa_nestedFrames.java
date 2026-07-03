package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment18_demoqa_nestedFrames {

	@Test
	public void testToSwitchToNewTab() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/nestedframes");

		// Switching to Parent frame
		driver.switchTo().frame("frame1");
		String parentBodyText = driver.findElement(By.tagName("body")).getText();
		System.out.println("Parent frame text " + parentBodyText);
		if (parentBodyText.equals("Parent frame")) {
			System.out.println("Switched to parent frame.");
		} else {
			System.out.println("Switch to parent frame failed.");
		}

		// Switching to Child frame
		WebElement childFrame = driver.findElement(By.xpath("//iframe[@srcdoc='<p>Child Iframe</p>']"));
		driver.switchTo().frame(childFrame);
		String childBodyText = driver.findElement(By.xpath("//p")).getText();
		System.out.println("Child iframe text: " + childBodyText);
		if (childBodyText.equals("Child Iframe")) {
			System.out.println("Switched to child frame.");
		} else {
			System.out.println("Switch to child frame failed.");
		}

		// Switching to default content.
		driver.switchTo().defaultContent();
		String mainPageHeader = driver.findElement(By.xpath("//h1")).getText();
		System.out.println("Main page header: " + mainPageHeader);
		if (mainPageHeader.equals("Nested Frames")) {
			System.out.println("Switched to default content.");
		} else {
			System.out.println("Switch to default content failed.");
		}
		driver.quit();
	}
}