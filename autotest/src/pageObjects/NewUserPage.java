package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NewUserPage {

private static WebElement element = null;
	
	public static WebElement txt_username(WebDriver driver) {
		element = driver.findElement(By.name("username"));
		return element;
	}
	
	public static WebElement txt_password(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement txt_cpass(WebDriver driver) {
		element = driver.findElement(By.name("cpassword"));
		return element;
	}
	
	public static WebElement btn_submit(WebDriver driver) {
		element = driver.findElement(By.id("btn_submit"));
		return element;
	}
}
