package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class tutorialNinjaRegister {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = "https://tutorialsninja.com/demo/index.php?route=account/login";
		driver.get(url);
		
		WebElement myAccountLink = driver.findElement(By.cssSelector("li.dropdown a[href$='/account']"));
		myAccountLink.click();
		WebElement registerLink = driver.findElement(By.cssSelector("ul.dropdown-menu-right a[href$='/register']"));
		registerLink.click();
		
		WebElement firstNameTextBox = driver.findElement(By.id("input-firstname"));
		firstNameTextBox.sendKeys("Test1");
		
		WebElement lastNameTextBox = driver.findElement(By.id("input-lastname"));
		lastNameTextBox.sendKeys("2026");
		
		WebElement emailTextBox = driver.findElement(By.id("input-email"));
		emailTextBox.sendKeys("Test12026@email.com");
		
		WebElement telephoneTextBox = driver.findElement(By.id("input-telephone"));
		telephoneTextBox.sendKeys("9999999999");
		
		WebElement passwordTextBox = driver.findElement(By.id("input-password"));
		passwordTextBox.sendKeys("Test12026@email");
		
		WebElement confirmPasswordTextBox = driver.findElement(By.id("input-confirm"));
		confirmPasswordTextBox.sendKeys("Test12026@email");
		
		WebElement privacyCheckbox = driver.findElement(By.xpath("//input[@name='agree']"));
		privacyCheckbox.click();
		
		WebElement continueButton = driver.findElement(By.className("btn-primary"));
		continueButton.click();
		
		Thread.sleep(3000);
		driver.quit();
	}

}
