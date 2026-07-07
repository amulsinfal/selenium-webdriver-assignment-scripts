package assignments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Assignment23_Incognito_Amazon {
	
	@Test
	public void incognitoMode() throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");	// launches the chrome browser in incognito mode.
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.navigate().to("https://www.amazon.in");
		Thread.sleep(3000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Mobile");
		Thread.sleep(3000);
		List<WebElement> mobileList = driver.findElements(By.cssSelector("span[class='s-heavy']"));
		System.out.println("Mobile Search Options:");
		for(WebElement option:mobileList) {
			if(option.getText().equals("")) {
				continue;
			} else {
				System.out.println(option.getText());
			}
		}
		driver.quit();
	}

}
