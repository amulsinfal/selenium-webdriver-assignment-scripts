package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment10_LoginWithInvalidPasswordUsingXpath {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://practicetestautomation.com/practice-test-login/";
		driver.get(url);
		// locating username text box using xpath //tagname[attribute='value']
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		// entering text in username textbox
		username.sendKeys("student");
		// locating password text box using xpath //tagname[attribute='value']
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		// entering text in password textbox
		password.sendKeys("Password1234");
		// locating login button using xapth //tagname[attribute='value']
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		// clicking on the login button
		loginButton.click();
		// Waiting for 3 sec
		Thread.sleep(3000);
		// locating success message button using xapth //tagname[@attribute='value']
		String errorMessage = driver.findElement(By.id("error")).getText();
		System.out.println("Error message: " +errorMessage);
		if (errorMessage.equals("Your password is invalid!")) {
			System.out.println("Correct error message is displayed - Test Passed.");
		} else {
			System.out.println("Incorrect error message displayed - Test Failed.");
		}
		// closing the browser
		driver.quit();
	}
}
