package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ElementUtils;

public class Assignment13_herokuapp_dropDown_3 {

	@Test
	public void selectDropOptions() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://the-internet.herokuapp.com/dropdown";
		driver.get(url);
		Thread.sleep(3000);
		// Identify the dropdown element (select).
		WebElement expDropdown = driver.findElement(By.id("dropdown"));
		ElementUtils.selectOptionByValue(expDropdown, "2");
		// expDropdown.selectByValue("2");
		Thread.sleep(3000);
		ElementUtils.selectOptionByIndex(expDropdown, 1);
		// expDropdown.selectByIndex(1);
		Thread.sleep(3000);
		ElementUtils.selectOptionByVisibleText(expDropdown, "Option 2");
		// expDropdown.selectByVisibleText("Option 2");
		Thread.sleep(5000);
		// closing the browser
		driver.quit();
	}
}
