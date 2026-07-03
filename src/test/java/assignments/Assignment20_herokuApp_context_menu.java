package assignments;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Assignment20_herokuApp_context_menu {

	@Test
	public void testToSwitchToNewTab() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/context_menu");
		WebElement targetELement = driver.findElement(By.id("hot-spot"));
		Actions actions = new Actions(driver);
		actions.contextClick(targetELement).perform(); // performing right click using actions class.
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert(); // switching to alert box.
		System.out.println("Text on alert prompt: " +alert.getText()); // print text in the alert box
		alert.accept(); // accepting the message on the alert box.
		Thread.sleep(2000);
		driver.quit();
	}
}