package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private static WebElement element = null;
	
	public static WebElement txt_username(WebDriver driver) {
		element = driver.findElement(By.name("username"));
		return element;
	}
	
	public static WebElement txt_password(WebDriver driver) {
		element = driver.findElement(By.name("password"));
		return element;
	}
	
	public static WebElement btn_login(WebDriver driver) {
		element = driver.findElement(By.id("btn_login"));
		return element;
	}
	
	public static WebElement lnk_forgotpass(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='./forgotpass.jsp']"));
		return element;
	}
	
	public static WebElement lnk_newuser(WebDriver driver) {
		element = driver.findElement(By.xpath("//a[@href='./newuser.jsp']"));
		return element;
	}
}
