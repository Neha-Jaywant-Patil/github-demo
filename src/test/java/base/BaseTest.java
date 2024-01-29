package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import demo.utility.Utility;

public class BaseTest {
	 static WebDriver driver;

	public  static WebDriver launchUrl(String url) {
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(Utility.readProperty("url"));
		return driver;

	}
}