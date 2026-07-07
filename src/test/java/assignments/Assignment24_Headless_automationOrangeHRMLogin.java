package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Assignment24_Headless_automationOrangeHRMLogin {
	
	@Test
	public void loginOrangeHRM() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		WebElement usernameTextbox = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		usernameTextbox.sendKeys("Admin");
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input[type='password']"));
		passwordTextbox.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
		loginButton.click();
		Thread.sleep(3000);
		WebElement pageHeader = driver.findElement(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
		boolean isDisplayed = pageHeader.isDisplayed();
		if(isDisplayed) {
			System.out.println("Dashboard is displayed. Login Successfull - Test Passed.");
		} else {
			System.out.println("Dashboard is not displayed. Login Un-successfull - Test Failed.");
		}
		WebElement userDropDown = driver.findElement(By.cssSelector("span.oxd-userdropdown-tab"));
		userDropDown.click();
		WebElement logoutButton = driver.findElement(By.cssSelector("ul.oxd-dropdown-menu>li:nth-child(4)>a"));
		logoutButton.click();
		WebElement loginLabel = driver.findElement(By.cssSelector("h5.orangehrm-login-title"));
		String actualText = loginLabel.getText();
		String expectedText = "Login";
		if(actualText.equals(expectedText)) {
			System.out.println("Login text is displayed. Logout Successfull - Test Passed.");
		} else {
			System.out.println("Login link is not displayed. Logout Un-successfull - Test Failed.");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}
