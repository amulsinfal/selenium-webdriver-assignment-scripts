package practise;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Redbus_Automate_Calendar {
	@Test
	public void selectDropOptions() throws InterruptedException {
		// Initialzie browser
		WebDriver driver = new ChromeDriver();
		
		// maximize window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		
		// Waiting for 3 seconds
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("div[class^='dateInputWrapper']")).click();
		Thread.sleep(3000);
		String day = "15";
		String month = "October";
		String year = "2026";

		while (true) {
			String cdate = driver.findElement(By.cssSelector("p[class^='monthYear_']")).getText();

			String cMonth = cdate.split(" ")[0];
			String cYear = cdate.split(" ")[1];

			if (cMonth.equals(month) && cYear.equals(year)) {
				System.out.println("Month found.");
				break;
			} else {
				driver.findElement(By.cssSelector("i[class*='right_']")).click();
			}
		}
		
		List<WebElement>  dateElements = driver.findElements(By.cssSelector("ul[class^='datesWrap'] div[class^='date_'] span"));
		for(WebElement date : dateElements) {
			if(date.getText().equals(day)) {
				date.click();
				break;
			}
		}
		Thread.sleep(3000);
		driver.quit();
	}
}