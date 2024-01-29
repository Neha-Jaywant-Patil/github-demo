package base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.utility.Utility;

public class ParallelExecution {
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
		// assertEquals(Title, "register","Title is equals");
		// assertNotEquals(Title,"register");
		// assertTrue(Title.equals("Register"));
		assertTrue(Title.equals("Register"), "Title is Equals");
	}

	@Test(description = "Verify url")
	public void url() {
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://demo.automationtesting.in/Register.html#google_vignette");
	}

	@Test(description = " verify Male button")
	public void maleButton() {
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://demo.automationtesting.in/Register.html#google_vignette");
		assertFalse(driver.findElement(By.xpath("//input[@value=\"Male\"]")).isSelected());
	}

	@Test(description = " verify cricket checkbox")
	public void cricketcheckbox() {
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://demo.automationtesting.in/Register.html#google_vignette");
		assertFalse(driver.findElement(By.xpath("//input[@value=\"Cricket\"]")).isSelected());
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
