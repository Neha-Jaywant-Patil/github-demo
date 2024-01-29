package base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import demo.utility.Utility;
//@Listeners (ListnerExamples.class)
public class HardAssertionImpl {
	WebDriver driver;

	@BeforeMethod
	public void launchUrl() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(Utility.readProperty("url"));

	}

	@Test(description = "Verify title")
	public void pagetitle() {

		String Title = driver.getTitle();
		//assertEquals(Title, "register","Title is equals");
		//assertNotEquals(Title,"register");
		//assertTrue(Title.equals("Register"));
		assertFalse(Title.equals("Register"),"Title is Equals");
	}
	@Test(description = "Verify url",enabled =false)
	public void url() {
		String url=driver.getCurrentUrl();
		assertEquals(url, "https://demo.automationtesting.in/Register.html#google_vignette");
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
