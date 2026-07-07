package practise;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ElementUtils;
public class Assignment_FindTotalSumOfPriceColumn {
	@Test
	public void verifyTotalSumOfPrice() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement tableHeading = driver.findElement(By.xpath("//h2[text()='Static Web Table']"));
		ElementUtils.scrollToElementUsingJS(driver, tableHeading);
		List<WebElement> tHeadList = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr/th"));
		int count = 0;
		int sum = 0;
		for (WebElement heading : tHeadList) {
			count++;
			if (heading.getText().equals("Price")) {
				List<WebElement> priceLists = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr//td[" + count + "]"));
				for (WebElement price : priceLists) {
					sum += Integer.parseInt(price.getText());
				}
			}
		}
		System.out.println("Total sum of price: " + sum);
		driver.quit();
	}
}