package assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5_TutorialNinjaLoginWithCssSelector {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		// Locating email address textbox with cssSelector - tagname#id
		WebElement emailTextbox = driver.findElement(By.cssSelector("#input-email"));
		emailTextbox.sendKeys("Test12026@email.com");
		// Locating password textbox with cssSelector - tagname[attribute='value']
		WebElement passwordTextbox = driver.findElement(By.cssSelector("input[placeholder='Password']"));
		passwordTextbox.sendKeys("Test12026@email");
		// Locating Login button with cssSelector - tagname.classname[attribute='value']
		WebElement loginButton = driver.findElement(By.cssSelector("input.btn-primary[value='Login']"));
		loginButton.click();
		// Waiting for 3 seconds
		Thread.sleep(3000);
		// Locating Logout link with cssSelector - tagname#id a[attribute$='partial ending string']
		WebElement logoutLink = driver.findElement(By.cssSelector("aside#column-right a[href$='/logout']"));
		// Returns true if logout link is displayed else false.
		boolean isDisplayed = logoutLink.isDisplayed();
		// Verifying if the logout link is displayed or not.
		if(isDisplayed) {
			System.out.println("Logout link is displayed. Login Successfull - Test Passed.");
		} else {
			System.out.println("Logout link is not displayed. Login Un-successfull - Test Failed.");
		}
		driver.quit();
	}
}
