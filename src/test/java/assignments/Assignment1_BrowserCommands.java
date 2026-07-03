package assignments;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1_BrowserCommands {

	public static void main(String[] args) {
		// Initialize Chrome browser.
		WebDriver driver = new ChromeDriver();
		// Maximize the browser.
		driver.manage().window().maximize();
		// Go to website "https://www.selenium.dev".
		driver.get("https://www.selenium.dev");
		// Retrieve and save the current url.
		String currentURL = driver.getCurrentUrl();
		System.out.println("Current Page URL is: " + currentURL);
		// Retrieve and Save the page title.
		String pageTitle = driver.getTitle();
		// Printing the page title on the console.
		System.out.println("Page title is: " + pageTitle);
		// Verify the page title contains "Selenium".
		if (pageTitle.contains("Selenium")) {
			System.out.println("Page title contains Selenium - Test Passed.");
		} else {
			System.out.println("Page title does not contain Selenium - Test failed.");
		}
		// Refreshing the browser.
		driver.navigate().refresh();
		// closing the browser.
		driver.quit();
	}
}
