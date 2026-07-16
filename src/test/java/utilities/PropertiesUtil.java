package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	
	public static String getProperties(String key) {
		Properties properties = new Properties();
		String propFile = System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties";
		FileInputStream fis;
		try {
			fis = new FileInputStream(propFile);
			properties.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
