package base;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ExplicitWaitDemo {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		WebElement start = driver.findElement(By.xpath("//button[text()='Remove']"));
		start.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Add']")));
		WebElement but1 = driver.findElement(By.xpath("//button[text()='Add']"));
		but1.click();
		System.out.println(but1.getAccessibleName());
		
		
		


	}
}