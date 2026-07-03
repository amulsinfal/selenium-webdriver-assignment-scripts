package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3_LoginFunctionality {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		// locating username text box using id locator
		WebElement username = driver.findElement(By.id("username"));
		// entering text in username textbox
		username.sendKeys("tomsmith");
		// locating password text box using id locator
		WebElement password = driver.findElement(By.id("password"));
		// entering text in password textbox
		password.sendKeys("SuperSecretPassword!");
		// locating login button using classname locator
		WebElement loginButton = driver.findElement(By.className("radius"));
		// clicking on the login button
		loginButton.click();
		// Waiting for 5 sec
		Thread.sleep(5000);
		// locating logout button using classname locator
		WebElement logoutButton = driver.findElement(By.className("icon-signout"));
		// Returns true if logout button is displayed else false.
		boolean isDisplayed = logoutButton.isDisplayed();
		// Verifying if the logout button is displayed or not.
		if (isDisplayed) {
			System.out.println("Logout button is displayed. Login Successfull - Test Passed.");
		} else {
			System.out.println("Logout button is not displayed. Login Un-successfull - Test Failed.");
		}
		// closing the browser
		driver.quit();
	}
}
