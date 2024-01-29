package base;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import demo.utility.UtilityExcel;

public class DataDriven extends BaseTest {
	 static WebDriver driver;

	public static void main(String[] args) throws IOException {
		driver = BaseTest.launchUrl("url");
		ArrayList<Object> data = UtilityExcel.readExcel(1);

		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder=\"First Name\"]"));

		firstName.sendKeys(data.get(0).toString());

		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder=\"Last Name\"]"));

		lastName.sendKeys(data.get(1).toString());

		WebElement email = driver.findElement(By.xpath("//input[@type=\"email\"]"));

		email.sendKeys(data.get(2).toString());

		WebElement mobnumber = driver.findElement(By.xpath("//input[@type=\"tel\"]"));

		mobnumber.sendKeys(data.get(3).toString());

	}

	
}
