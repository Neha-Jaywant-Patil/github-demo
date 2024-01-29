package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

public class WaitFluentDemo {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		driver.manage().window().maximize();
		WebElement start = driver.findElement(By.xpath("//button[text()='Enable']"));
		start.click();
		
		/*FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
		fluentWait.withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofMillis(100))
				.ignoring(TimeoutException.class)
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='Disable']")));*/
		WebElement add = driver.findElement(By.xpath("//button[text()='Disable']"));
		add.click();
		System.out.println(add.getText());
	}

}
