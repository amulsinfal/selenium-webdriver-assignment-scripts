package assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment12_redbus_dropDown_02 {
	@Test
	public void selectDropOptions() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.redbus.in/";
		driver.get(url);
		Thread.sleep(3000);
		System.out.println("\nSOURCE");
		driver.findElement(By.id("srcinput")).sendKeys("Pune");
		Thread.sleep(3000);
		List<WebElement> allSourceOptions = driver.findElements(
				By.cssSelector("div[class^='searchCategory']>div[id^='suggestion'] div[role='heading']"));
		System.out.println("Total Options are: " + allSourceOptions.size());
		for (WebElement option : allSourceOptions) {
			System.out.println(option.getText());
			if (option.getText().contains("Nigdi")) {
				System.out.println("CLICKED: " + option.getText());
				option.click();
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println("\nDESTINATION");
		driver.findElement(By.id("destinput")).sendKeys("Mumbai");
		Thread.sleep(3000);
		List<WebElement> allDestOptions = driver.findElements(
				By.xpath("//div[contains(@class,'searchCategory')]/div[contains(@id,'suggestion')]//div[@role='heading']"));
		System.out.println("Total Options are: " + allDestOptions.size());
		for (WebElement option : allDestOptions) {
			System.out.println(option.getText());
			if (option.getText().contains("Sion")) {
				System.out.println("CLICKED: " + option.getText());
				option.click();
				break;
			}
		}
		driver.quit();
	}
}
