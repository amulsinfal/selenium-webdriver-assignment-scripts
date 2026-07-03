package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7_LoginFunctionalityUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		// locating username text box using xpath //tagname[attribute='value']
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		// entering text in username textbox
		username.sendKeys("tomsmith");
		// locating password text box using xpath //tagname[attribute='value']
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		// entering text in password textbox
		password.sendKeys("SuperSecretPassword!");
		// locating login button using xapth //tagname[attribute='value']
		WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
		// clicking on the login button
		loginButton.click();
		// Waiting for 5 sec
		Thread.sleep(5000);
		// locating logout button using xpath //tagname[attribute='value']
		WebElement logoutButton = driver.findElement(By.xpath("//a[@href='/logout']"));
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
