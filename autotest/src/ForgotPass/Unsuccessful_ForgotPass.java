package ForgotPass;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.ForgotPassPage;
import pageObjects.HomePage;

public class Unsuccessful_ForgotPass {
	private static WebDriver driver = null;

	@Test
	public void main() {
		String baseURL = "http://localhost:8080/Simple_Login_WebApp/index.jsp";

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//------------------------------
		//empty email
		//------------------------------
		
		
		driver.get(baseURL);

		HomePage.lnk_forgotpass(driver).click();


		ForgotPassPage.txt_email(driver).sendKeys("");
		ForgotPassPage.btn_submit(driver).click();


		String expectedURL2 = "http://localhost:8080/Simple_Login_WebApp/ForgotPass";
		String actualURL2 = "";
		String expectedmsg2 = "Cannot be blank!";
		String actualmsg2 = "";

		actualURL2 = driver.getCurrentUrl();
		actualmsg2 = driver.findElement(By.tagName("body")).getText();

		if (actualURL2.contentEquals(expectedURL2) && expectedmsg2.contentEquals(actualmsg2)) {
			System.out.println("Unsuccessful Forgot Password when Email is empty: Test Passed");
		} else {
			System.out.println("Unsuccesful Forgot Password when Email is empty: Test Failed");
		}

		//------------------------------
		//invalid email
		//------------------------------
		
		
		driver.get(baseURL);

		HomePage.lnk_forgotpass(driver).click();


		ForgotPassPage.txt_email(driver).sendKeys("invalid@email.com");
		ForgotPassPage.btn_submit(driver).click();


		String expectedURL3 = "http://localhost:8080/Simple_Login_WebApp/ForgotPass";
		String actualURL3 = "";
		String expectedmsg3 = "Invalid Email!";
		String actualmsg3 = "";

		actualURL3 = driver.getCurrentUrl();
		actualmsg3 = driver.findElement(By.tagName("body")).getText();

		if (actualURL3.contentEquals(expectedURL3) && expectedmsg3.contentEquals(actualmsg3)) {
			System.out.println("Unsuccessful Forgot Password when Email is invalid: Test Passed");
		} else {
			System.out.println("Unsuccesful Forgot Password when Email is invalid: Test Failed");
		}
		
		
		driver.close();

	}
}
