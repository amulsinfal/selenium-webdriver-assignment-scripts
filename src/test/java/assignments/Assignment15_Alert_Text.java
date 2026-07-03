package assignments;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Assignment15_Alert_Text {
	@Test
	public void testToPrintAlertTextOnConsole() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://formy-project.herokuapp.com/switch-window");
		Thread.sleep(2000);
		driver.findElement(By.id("alert-button")).click();
		// Switch to alert
		Alert alert = driver.switchTo().alert();
		// Get the text from alert and save it to a string variable
		String actualAlertText = alert.getText();
		System.out.println("Alert message: " + actualAlertText);
		driver.quit();
	}
}