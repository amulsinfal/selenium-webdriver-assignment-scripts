package assignments;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment4_AssignmentStatement {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.naukri.com/";
		driver.get(url);
		// Return all the list of WebElement with tag "a"
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		System.out.println("Total links on the page: " + allLinks.size());
		// Enhanced loop for iterating through each webelement.
		for(WebElement link : allLinks) {
			// Print the link text on the console of each link
			System.out.println("\nLink text: " + link.getText());
			// // Print the href text on the console of each link
			System.out.println("href value: " + link.getDomAttribute("href"));
		}
		// Closing the browser
		driver.quit();
	}
}
