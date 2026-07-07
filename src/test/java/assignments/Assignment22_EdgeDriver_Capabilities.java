package assignments;

import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Assignment22_EdgeDriver_Capabilities {
	
	@Test
	public void getEdgeDriver_AllCapabilities() {
		EdgeDriver driver = new EdgeDriver();
		Capabilities cap = driver.getCapabilities();
		Map<String, Object> allProperties = cap.asMap();
		System.out.println("EdgeDriver all properties:" + allProperties);
		driver.quit();
	}
}
