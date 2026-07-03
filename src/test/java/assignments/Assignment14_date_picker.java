package assignments;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utilities.ElementUtils;

public class Assignment14_date_picker {
	@Test
	public void automateDatPicker() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demoqa.com/date-picker");
		Thread.sleep(3000);
		// Date to be selected
		String date = "29";
		String month = "November";
		String year = "2030";
		// Clicking the date input box to open calendar
		WebElement datePickerTextBox = driver.findElement(By.cssSelector("#datePickerMonthYearInput"));
		datePickerTextBox.click();
		Thread.sleep(3000);
		// Locating the month dropdown element
		WebElement monthDropDown = driver.findElement(By.cssSelector("select[class='react-datepicker__month-select']"));
		// Using Utility to select the month option by visible text.
		ElementUtils.selectOptionByVisibleText(monthDropDown, month);
		// Locating the year dropdown element
		WebElement yearDropDown = driver.findElement(By.cssSelector("select[class='react-datepicker__year-select']"));
		// Using Utility to select the year option by visible text.
		ElementUtils.selectOptionByVisibleText(yearDropDown, year);
		// Finding all the date element from the calendar
		List<WebElement> listOfDates = driver.findElements(
				By.cssSelector("div[class='react-datepicker__month'] div[class*='react-datepicker__day'"));
		for (WebElement dateElement : listOfDates) {
			// condition to check if aria-label attribute value contains month and visible text contains date
			if (dateElement.getDomAttribute("aria-label").contains(month) && dateElement.getText().contains(date)) {
				dateElement.click(); // date is clicked if attribute "aria-label" value contains "November" and Visible text is "29";
				break;
			}
		}
		Thread.sleep(3000);
		System.out.println("Date selected from the calendar: " + datePickerTextBox.getDomAttribute("value")); // 11/29/2030
		driver.quit();
	}
}