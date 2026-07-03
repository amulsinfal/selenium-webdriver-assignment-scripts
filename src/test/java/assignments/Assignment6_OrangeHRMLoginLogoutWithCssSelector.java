package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6_OrangeHRMLoginLogoutWithCssSelector {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String url = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
		driver.get(url);
		// Locating username textbox with cssSelector - tagname[attribute='value']
		WebElement usernameTextbox = driver.findElement(By.cssSelector("input[placeholder='Username']"));
		usernameTextbox.sendKeys("Admin");
		// Locating password textbox with cssSelector - tagname[attribute='value']
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input[type='password']"));
		passwordTextbox.sendKeys("admin123");
		// Locating Login button with cssSelector - tagname.classname
		WebElement loginButton = driver.findElement(By.cssSelector("button.orangehrm-login-button"));
		loginButton.click();
		Thread.sleep(3000);
		// Locating page header Text element with cssSelector - tagname.classname
		WebElement pageHeader = driver.findElement(By.cssSelector("h6.oxd-topbar-header-breadcrumb-module"));
		// Returns true if page header text element is displayed else false.
		boolean isDisplayed = pageHeader.isDisplayed();
		// Verifying if the Dashboard label element is displayed or not.
		if(isDisplayed) {
			System.out.println("Dashboard is displayed. Login Successfull - Test Passed.");
		} else {
			System.out.println("Dashboard is not displayed. Login Un-successfull - Test Failed.");
		}
		// Locating user dropdown button with cssSelector - tagname.classname
		WebElement userDropDown = driver.findElement(By.cssSelector("span.oxd-userdropdown-tab"));
		userDropDown.click();
		// Locating logout button from user drop down list with cssSelector - tagname.classname>tagname:nth-child(index)
		WebElement logoutButton = driver.findElement(By.cssSelector("ul.oxd-dropdown-menu>li:nth-child(4)>a"));
		logoutButton.click();
		// Locating Login Text with cssSelector - tagname.classname
		WebElement loginLabel = driver.findElement(By.cssSelector("h5.orangehrm-login-title"));
		// Returns text from loginLabel web element and saving it to a string variable.
		String actualText = loginLabel.getText();
		String expectedText = "Login";
		// Verifying the text displayed is Login or not.
		if(actualText.equals(expectedText)) {
			System.out.println("Login text is displayed. Logout Successfull - Test Passed.");
		} else {
			System.out.println("Login link is not displayed. Logout Un-successfull - Test Failed.");
		}
		Thread.sleep(3000);
		driver.quit();
	}
}