package base;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class ImplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://testpages.eviltester.com/styled/dynamic-buttons-simple.html");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement element = driver.findElement(By.xpath("//button[@id=\"button00\"]"));
		element.click();
		WebElement but1 = driver.findElement(By.xpath("//button[@id=\"button01\"]"));
		but1.click();
		WebElement but2 = driver.findElement(By.xpath("//button[@id=\"button02\"]"));
		but2.click();
		System.out.println(but2.getText());
		
		
		

	}

}
