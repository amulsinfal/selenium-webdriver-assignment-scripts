package assignments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment8_LoginFunctionalityUsingXpath {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		// locating username text box using xpath //tagname[attribute='value']
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		// entering text in username textbox
		username.sendKeys("student");
		// locating password text box using xpath //tagname[attribute='value']
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		// entering text in password textbox
		password.sendKeys("Password123");
		// locating login button using xapth //tagname[attribute='value']
		WebElement loginButton = driver.findElement(By.xpath("//button[text()='Submit']"));
		// clicking on the login button
		loginButton.click();
		// Waiting for 3 sec
		Thread.sleep(3000);
		// locating success message button using xapth //tagname[@attribute='value']
		String successMessage = driver.findElement(By.xpath("//div[@class='post-header']/h1")).getText();
		if (successMessage.equals("Logged In Successfully")) {
			System.out.println("Success Message is displayed correctly - Test Passed.");
		} else {
			System.out.println("Success Message is not displayed correctly - Test Failed.");
		}
		// locating congratulation message button using xapth //tagname[@attribute='value']
		String congratsMessage = driver.findElement(By.xpath("//div[@class='post-content']/p/strong")).getText();
		if (congratsMessage.equals("Congratulations student. You successfully logged in!")) {
			System.out.println("Congratulation Message is displayed correctly - Test Passed.");
		} else {
			System.out.println("Congratulation message is not displayed - Test Failed.");
		}
		// locating logout button using xpath //tagname[text()='value']
		boolean isDisplayed = driver.findElement(By.xpath("//a[text()='Log out']")).isDisplayed();
		if (isDisplayed) {
			System.out.println("Logout button is displayed - Test Passed.");
		} else {
			System.out.println("Logout button is not displayed - Test Failed.");
		}
		// closing the browser
		driver.quit();
	}
}