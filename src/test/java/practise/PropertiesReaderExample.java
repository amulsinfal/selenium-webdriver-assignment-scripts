package practise;
import org.testng.annotations.Test;
import utilities.PropertiesUtil;
public class PropertiesReaderExample {
	@Test
	public void readValuesFromPropertiesFile() {
		System.out.println("Browser value in properties file: " + PropertiesUtil.getProperties("browser"));
		System.out.println("URL value in properties file: " + PropertiesUtil.getProperties("url"));
		System.out.println("Username value in properties file: " + PropertiesUtil.getProperties("username"));
		System.out.println("Password value in properties file: " + PropertiesUtil.getProperties("password"));
	}
}