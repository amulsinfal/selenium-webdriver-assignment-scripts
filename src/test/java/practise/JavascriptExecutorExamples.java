package practise;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavascriptExecutorExamples {
	
	@Test
	public void ScrollDown() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void ScrollTo() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void ScrollToElement() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		WebElement targetElement = driver.findElement(By.xpath("//span[contains(text(),'Trendy furniture, amazing prices')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("arguments[0].scrollIntoView(true)", targetElement);
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void getPageTitleUsingJS() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		String actualTitle = js.executeScript("return document.title").toString();
		String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		System.out.println("Page title: " + actualTitle);
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Page title is correct - Test Passed");
		} else {
			System.out.println("Page title is incorrect - Test Failed");
		}
		driver.quit();
	}
	
	@Test
	public void refreshPageUsingJS() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		js.executeScript("history.go()");
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void clickElementUsingJS() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://formy-project.herokuapp.com/form");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement gradOption = driver.findElement(By.id("radio-button-3"));
		boolean gradOptionSelected = gradOption.isSelected();
		System.out.println("Is grad School option selected: " +gradOptionSelected );
		if(!gradOptionSelected) {
			js.executeScript("arguments[0].click()", gradOption);
			System.out.println("Grad School option clicked.");
		}
		gradOptionSelected = driver.findElement(By.id("radio-button-3")).isSelected();
		System.out.println("Is grad School option selected: " +gradOptionSelected );
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void enterTextInElementUsingJS() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://formy-project.herokuapp.com/form");
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement firstNameTextbox = driver.findElement(By.cssSelector("input#first-name"));
		js.executeScript("arguments[0].value='John'", firstNameTextbox);
		Thread.sleep(2000);
		driver.quit();
	}
	
	
}
