package assignments;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ElementUtils;
public class Assignment21_VerifyTheCellValueInDynamicTable {
	@Test
	public void verifyTheCellValueInATable() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebElement tableHeading = driver.findElement(By.xpath("//h2[text()='Dynamic Web Table']"));
		ElementUtils.scrollToElementUsingJS(driver, tableHeading);
		String actualText = null;
		String expectedText = null;
		
		actualText = getCellDetails(driver, "CPU", "Chrome");
		System.out.println("CPU load of Chrome process: " + actualText);
		expectedText = driver.findElement(By.cssSelector("#displayValues [class='chrome-cpu']")).getText();
		
		if(actualText.equals(expectedText)) {
			System.out.println("CPU load of Chrome process is matching - Test Passed.");
		} else {
			System.out.println("CPU load of Chrome process is not matching - Test Failed.");
		}
		
		actualText = getCellDetails(driver, "Memory", "Firefox");
		System.out.println("Memory Size of Firefox process: " + actualText);
		expectedText = driver.findElement(By.cssSelector("#displayValues [class='firefox-memory']")).getText();

		if(actualText.equals(expectedText)) {
			System.out.println("Memory Size of Firefox process is matching - Test Passed.");
		} else {
			System.out.println("Memory Size of Firefox process is not matching - Test Failed.");
		}
		
		actualText = getCellDetails(driver, "Network", "Chrome");
		System.out.println("Network speed of Chrome process: " + actualText);
		expectedText = driver.findElement(By.cssSelector("#displayValues [class='chrome-network']")).getText();

		if(actualText.equals(expectedText)) {
			System.out.println("Network speed of Chrome process is matching - Test Passed.");
		} else {
			System.out.println("Network speed of Chrome process is not matching - Test Failed.");
		}
		
		actualText = getCellDetails(driver, "Disk", "Firefox");
		System.out.println("Disk space of Firefox process: " + actualText);
		expectedText = driver.findElement(By.cssSelector("#displayValues [class='firefox-disk']")).getText();

		if(actualText.equals(expectedText)) {
			System.out.println("Disk space of Firefox process is matching - Test Passed.");
		} else {
			System.out.println("Disk space of Firefox process is not matching - Test Failed.");
		}
		
		driver.quit();
	}
	
	private String getCellDetails(WebDriver driver, String columnHeader, String nameValue) {
		List<WebElement> headerList = driver.findElements(By.xpath("//table[@id='taskTable']//tr//th"));
		int colNum = 0;
		String expectedHeader = columnHeader;
		for(WebElement header : headerList) {
			colNum++;
			if(header.getText().contains(expectedHeader)) {
				break;
			}				
		} // colNum = will contain the column number (say 2) of the value columnHeader (CPU).
		
		List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='taskTable']//tbody//tr/td[1]"));
		int rowNum = 0;
		for(WebElement row : rowList) {
			rowNum++;
			if(row.getText().contains(nameValue)) {
				break;
			}				
		} // rowNum will contain the row number (say 3) of the Namevalue ("Chrome") column Index.
		
		WebElement cellValue = driver.findElement(By.xpath("//table[@id='taskTable']//tr[" + rowNum + "]//td[" + colNum + "]"));
		return cellValue.getText(); // this will return the cell value.(e.g.: CPU & Chrome)
	}
}