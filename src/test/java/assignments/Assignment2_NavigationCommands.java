package assignments;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment2_NavigationCommands {
	
	public static void main(String[] args) {
		// Initialize Chrome browser.
		WebDriver driver = new ChromeDriver();
		// Maximize the browser.
		driver.manage().window().maximize();
		System.out.println("Going to https://www.demoblaze.com website");
		// Go to website "https://www.demoblaze.com".
		driver.get("https://www.demoblaze.com");
		// Retrieve and save the current url.
		System.out.println("Current Page URL is: " + driver.getCurrentUrl());
		System.out.println("\nNavigating to https://demoqa.com website");
		// Navigating to website "https://demoqa.com".
		driver.navigate().to("https://demoqa.com");
		// Retrieve and save the current url.
		System.out.println("Current Page URL is: " + driver.getCurrentUrl());
		System.out.println("\nNavigating to https://automationexercise.com website");
		// Navigating to website https://automationexercise.com
		driver.navigate().to("https://automationexercise.com");
		// Retrieve and save the current url.
		System.out.println("Current Page URL is: " + driver.getCurrentUrl());
		System.out.println("\nNavigating back to https://demoqa.com website");
		// Navigating back to a website from the history - https://demoqa.com website
		driver.navigate().back();
		// Retrieve and save the current url.
		System.out.println("Current Page URL is: " + driver.getCurrentUrl());
		// Verify the current page url is "https://demoqa.com/".
		if (driver.getCurrentUrl().contains("https://demoqa.com/")) {
			System.out.println("Current page url is matching - Test Passed.");
		} else {
			System.out.println("Current page url is not matching - Test failed.");
		}
		System.out.println("\nNavigating forward to https://automationexercise.com website");
		// Navigates forward to a website from history - https://automationexercise.com website
		driver.navigate().forward();
		// Retrieve and save the current url.
		System.out.println("Current Page URL is: " + driver.getCurrentUrl());
		// Verify the current page url is "https://automationexercise.com/".
		if (driver.getCurrentUrl().contains("https://automationexercise.com/")) {
			System.out.println("Current page url is matching - Test Passed.");
		} else {
			System.out.println("Current page url is not matching - Test failed.");
		}
		driver.navigate().refresh();
		driver.quit();
	}
}