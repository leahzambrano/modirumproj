package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassPage {
private static WebElement element = null;
	
	public static WebElement txt_email(WebDriver driver) {
		element = driver.findElement(By.name("email"));
		return element;
	}
	
	public static WebElement btn_submit(WebDriver driver) {
		element = driver.findElement(By.id("btn_submit"));
		return element;
	}
}
