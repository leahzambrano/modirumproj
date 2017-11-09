package NewUser;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.ForgotPassPage;
import pageObjects.HomePage;
import pageObjects.NewUserPage;

public class Successful_NewUser {

	private static WebDriver driver = null;

	@Test
	public void main() {
		String baseURL = "http://localhost:8080/Simple_Login_WebApp/index.jsp";

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL = "";

		actualURL = driver.getCurrentUrl();

		if (actualURL.contentEquals(expectedURL)) {
			NewUserPage.txt_username(driver).sendKeys("newuser1");
			NewUserPage.txt_password(driver).sendKeys("pass123");
			NewUserPage.txt_cpass(driver).sendKeys("pass123");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL2 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL2 = "";
		String expectedmsg2 = "User has been successfully added!";
		String actualmsg2 = "";

		actualURL2 = driver.getCurrentUrl();
		actualmsg2 = driver.findElement(By.tagName("body")).getText();

		if (actualURL2.contentEquals(expectedURL2) && expectedmsg2.contentEquals(actualmsg2)) {
			System.out.println("Successful New User: Test Passed");
		} else {
			System.out.println("Succesful New User: Test Failed");
		}

		driver.close();

	}

	
	
}
