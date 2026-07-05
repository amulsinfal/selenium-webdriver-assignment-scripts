package utilities;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ElementUtils {

	public static void selectOptionByValue(WebElement element, String value) {
		Select option = new Select(element);
		option.selectByValue(value);
	}

	public static void selectOptionByIndex(WebElement element, int value) {
		Select option = new Select(element);
		option.selectByIndex(value);
	}

	public static void selectOptionByVisibleText(WebElement element, String value) {
		Select option = new Select(element);
		option.selectByVisibleText(value);
	}

	public static void scrollDownUsingJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpUsingJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	public static void scrollToElementUsingJS(WebDriver driver, WebElement targetElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", targetElement);
	}

	public static String getTitleUsingJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}

	public static void refreshUsingJS(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go()");
	}

	public static void clickUsingJS(WebDriver driver, WebElement targetElement) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", targetElement);
	}

	public static void enterTextUsingJS(WebDriver driver, WebElement targetElement, String value) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='" + value + "'", targetElement);
	}

	public static void switchToWindow(WebDriver driver, Set<String> ids, String Id) {
		for (String i : ids) {
			if (!i.equals(Id)) {
				driver.switchTo().window(i);
				System.out.println("Switched window.");
				break;
			}
		}
	}

	public static void switchToWindow(WebDriver driver, String id) {
		driver.switchTo().window(id);
		System.out.println("Switched window.");
	}

	public static void switchToWindowUsingTitle(WebDriver driver, Set<String> ids, String value) {
		for (String i : ids) {
			String cPageTitle = driver.switchTo().window(i).getTitle();
			if (cPageTitle.contains(value)) {
				driver.switchTo().window(i);
				System.out.println("Switched to window with title " + value);
				break;
			}
		}
	}
	
	public static void switchToFrameUsingIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	
	public static void switchToFrameUsingNameOrID(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}
	
}
