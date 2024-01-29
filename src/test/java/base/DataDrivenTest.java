package base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import demo.utility.Utility;

public class DataDrivenTest {
	WebDriver driver;

	@BeforeMethod
	public void launchUrl() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(Utility.readProperty("urlnew1"));

	}
	@Test(dataProvider = "userCreadentials")
	public void verifyDifferentUserLogin(String uname, String pass) {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@id=\"submit\"]")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"))));

		WebElement loginSuccessfulMsg = driver.findElement(By.xpath("//h1[text()='Logged In Successfully']"));

		assertTrue(loginSuccessfulMsg.getText().equals("Logged In Successfully"), "User not successfully logged in");
	}

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@DataProvider(name = "userCreadentials")
	public Object[][] data() {

		Object userData[][] = { { "student", "Password123" }, { "student", "pass123" }, { "Student", "123Pass" } };

		return userData;
	}

}


