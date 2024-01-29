package base;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demo.utility.Utility;

public class TestNGPractice {
	WebDriver driver;

	@BeforeMethod
	public void launchUrl() {
		driver = new EdgeDriver();
		driver.manage().window().maximize();

		driver.get(Utility.readProperty("url"));

	}
@Test(enabled=false)
public void verifyDropDownOptions() {
	List<String> dropDownOptions = Arrays.asList("Adobe InDesign,Adobe Photoshop,Analytics,Android,APIs,Art Design,AutoCAD");
	List<WebElement> actualDropdownOptions = driver.findElements(By.xpath("//select[@type=\"text\"]"));
	WebElement selectTagWebElement = driver.findElement(By.xpath("//select[@type=\"text\"]"));

	Select select = new Select(selectTagWebElement);
	List<WebElement> dropdownoptions = select.getOptions();

	ArrayList<String> dropdownOptions = new ArrayList<String>();

	for (WebElement option : dropdownoptions) {
		dropdownOptions.add(option.getText());
	}

	assertEquals(dropdownOptions, dropDownOptions, "dropdown options are less in size");

}
@Test(description = "Verify title")
public void pagetitle() {

	String Title = driver.getTitle();
	assertEquals(Title, "Register","Title is equals");
}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}



