package ForgotPass;

import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;
import pageObjects.ForgotPassPage;

public class Successful_ForgotPass {

	private static WebDriver driver = null;

	@Test
	public void main() {
		String baseURL = "http://localhost:8080/Simple_Login_WebApp/index.jsp";

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

		HomePage.lnk_forgotpass(driver).click();

		String expectedURL = "http://localhost:8080/Simple_Login_WebApp/forgotpass.jsp";
		String actualURL = "";

		actualURL = driver.getCurrentUrl();

		if (actualURL.contentEquals(expectedURL)) {
			ForgotPassPage.txt_email(driver).sendKeys("sample@email.com");
			ForgotPassPage.btn_submit(driver).click();
		}

		String expectedURL2 = "http://localhost:8080/Simple_Login_WebApp/ForgotPass";
		String actualURL2 = "";
		String expectedmsg2 = "Your password has been successfully sent to your email!";
		String actualmsg2 = "";

		actualURL2 = driver.getCurrentUrl();
		actualmsg2 = driver.findElement(By.tagName("body")).getText();

		if (actualURL2.contentEquals(expectedURL2) && expectedmsg2.contentEquals(actualmsg2)) {
			System.out.println("Successful Forgot Password: Test Passed");
		} else {
			System.out.println("Succesful Forgot Password: Test Failed");
		}

		driver.close();

	}
}
