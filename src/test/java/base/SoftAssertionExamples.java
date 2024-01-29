package base;

import static org.testng.Assert.assertFalse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import demo.utility.Utility;
@Listeners (ListnerExamples.class)
public class SoftAssertionExamples {
	WebDriver driver;
SoftAssert softassert;
	@BeforeMethod
	public void launchUrl() {
		softassert=new SoftAssert();
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(Utility.readProperty("urlnew"));

	}

	@Test(description = "Verify title")
	public void pagetitle() {

		String Title = driver.getTitle();
		softassert.assertEquals(Title, "Dynamic buttons","Title is equals");
		softassert.assertNotEquals(Title,"dynamic buttons");
		softassert.assertTrue(Title.equals("Dynamic Buttons"));
		softassert.assertFalse(Title.equals("Dynamic Buttons"),"Title is Equals");
		softassert.assertAll();
	}
	@Test(description = "Verify url")
	public void url() {
		String url=driver.getCurrentUrl();
		softassert.assertEquals(url, "https://testpages.eviltester.com/styled/dynamic-buttons-simple.html");
		softassert.assertAll();
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
