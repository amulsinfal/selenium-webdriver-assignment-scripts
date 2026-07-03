package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ElementUtils;
public class Assignment11_formy_project_dropDown_01 {
	@Test
	public void selectDropOptions() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://formy-project.herokuapp.com/form");
		driver.findElement(By.cssSelector("input#first-name")).sendKeys("TestFirstName");
		driver.findElement(By.cssSelector("input#last-name")).sendKeys("TestLastName");
		driver.findElement(By.cssSelector("input#job-title")).sendKeys("Automation Tester");
		boolean highSchoolOptions = driver.findElement(By.id("radio-button-1")).isSelected();
		if(highSchoolOptions) {
			driver.findElement(By.id("radio-button-1")).click();
		}
		boolean collegeOptions = driver.findElement(By.id("radio-button-2")).isSelected();
		if(collegeOptions) {
			driver.findElement(By.id("radio-button-2")).click();
		}
		boolean gradOption = driver.findElement(By.id("radio-button-3")).isSelected();
		if(!gradOption) {
			driver.findElement(By.id("radio-button-3")).click();
		}
		boolean maleOptionSelected = driver.findElement(By.id("checkbox-1")).isSelected();
		if(!maleOptionSelected) {
			driver.findElement(By.id("checkbox-1")).click();
		}
		boolean femaleOptionSelected = driver.findElement(By.id("checkbox-2")).isSelected();
		if(femaleOptionSelected) {
			driver.findElement(By.id("checkbox-2")).click();
		}
		boolean otherOptionSelected = driver.findElement(By.id("checkbox-3")).isSelected();
		if(otherOptionSelected) {
			driver.findElement(By.id("checkbox-3s")).click();
		}
		// Identify the dropdown element (select).
		WebElement expDropdown = driver.findElement(By.id("select-menu"));
		ElementUtils.selectOptionByValue(expDropdown, "2");
//		expOption.selectByValue("2");
		Thread.sleep(3000);
		ElementUtils.selectOptionByIndex(expDropdown, 1);
//		expOption.selectByIndex(1);
		Thread.sleep(3000);
		ElementUtils.selectOptionByVisibleText(expDropdown, "10+");
//		expOption.selectByVisibleText("10+");
		Thread.sleep(5000);
		// closing the browser
		driver.quit();
	}
}