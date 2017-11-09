package Login;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;

public class Unsuccessful_Login {

	private static WebDriver driver = null;

	@Test
	public void main() {
		String baseURL = "http://localhost:8080/Simple_Login_WebApp/index.jsp";

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);

		// ------------------------
		// blank fields
		// ------------------------

		driver.get(baseURL);

		HomePage.txt_username(driver).sendKeys("");
		HomePage.txt_password(driver).sendKeys("");
		HomePage.btn_login(driver).click();

		String expectedURL2 = "http://localhost:8080/Simple_Login_WebApp/LoginCheck";
		String actualURL2 = "";
		String expectederr2 = "Cannot be blank!";
		String actualerr2 = "";

		actualURL2 = driver.getCurrentUrl();
		actualerr2 = driver.findElement(By.tagName("body")).getText();

		if (actualURL2.contentEquals(expectedURL2) && expectederr2.contentEquals(actualerr2)) {
			System.out.println("Unsuccessful Login when empty fields: Test Passed");
		} else {
			System.out.println("Unsuccessful Login when empty fields: Test Failed");
		}

		// ------------------------
		// username is blank
		// ------------------------

		driver.get(baseURL);

		HomePage.txt_username(driver).sendKeys("");
		HomePage.txt_password(driver).sendKeys("pass123");
		HomePage.btn_login(driver).click();

		String expectedURL3 = "http://localhost:8080/Simple_Login_WebApp/LoginCheck";
		String actualURL3 = "";
		String expectederr3 = "Cannot be blank!";
		String actualerr3 = "";

		actualURL3 = driver.getCurrentUrl();
		actualerr3 = driver.findElement(By.tagName("body")).getText();

		if (actualURL3.contentEquals(expectedURL3) && expectederr3.contentEquals(actualerr3)) {
			System.out.println("Unsuccessful Login when Username is empty: Test Passed");
		} else {
			System.out.println("Unsuccessful Login when Username is empty: Test Failed");
		}

		// ------------------------
		// password is blank
		// ------------------------

		driver.get(baseURL);

		HomePage.txt_username(driver).sendKeys("Admin");
		HomePage.txt_password(driver).sendKeys("");
		HomePage.btn_login(driver).click();

		String expectedURL4 = "http://localhost:8080/Simple_Login_WebApp/LoginCheck";
		String actualURL4 = "";
		String expectederr4 = "Cannot be blank!";
		String actualerr4 = "";

		actualURL4 = driver.getCurrentUrl();
		actualerr4 = driver.findElement(By.tagName("body")).getText();

		if (actualURL4.contentEquals(expectedURL4) && expectederr4.contentEquals(actualerr4)) {
			System.out.println("Unsuccessful Login when Password is empty: Test Passed");
		} else {
			System.out.println("Unsuccessful Login when Password is empty: Test Failed");
		}
		// ------------------------
		// invalid credentials
		// ------------------------
		driver.get(baseURL);
		
		HomePage.txt_username(driver).sendKeys("invaliduser");
		HomePage.txt_password(driver).sendKeys("invalidpass");
		HomePage.btn_login(driver).click();

		String expectedURL = "http://localhost:8080/Simple_Login_WebApp/LoginCheck";
		String actualURL = "";
		String expectederr = "Invalid Credentials!";
		String actualerr = "";

		actualURL = driver.getCurrentUrl();
		actualerr = driver.findElement(By.tagName("body")).getText();

		if (actualURL.contentEquals(expectedURL) && expectederr.contentEquals(actualerr)) {
			System.out.println("Unsuccessful Login using invalid credentials: Test Passed");
		} else {
			System.out.println("Unsuccessful Login using invalid credentials: Test Failed");
		}

		// ------------------------
		// invalid username
		// ------------------------
		driver.get(baseURL);
		
		HomePage.txt_username(driver).sendKeys("invaliduser");
		HomePage.txt_password(driver).sendKeys("Pass123");
		HomePage.btn_login(driver).click();

		String expectedURL5 = "http://localhost:8080/Simple_Login_WebApp/LoginCheck";
		String actualURL5 = "";
		String expectederr5 = "Invalid Credentials!";
		String actualerr5 = "";

		actualURL5 = driver.getCurrentUrl();
		actualerr5 = driver.findElement(By.tagName("body")).getText();

		if (actualURL5.contentEquals(expectedURL5) && expectederr5.contentEquals(actualerr5)) {
			System.out.println("Unsuccessful Login using invalid Username: Test Passed");
		} else {
			System.out.println("Unsuccessful Login using invalid Username: Test Failed");
		}

		// ------------------------
		// invalid password
		// ------------------------

		driver.get(baseURL);
		
		HomePage.txt_username(driver).sendKeys("Admin");
		HomePage.txt_password(driver).sendKeys("invalidpassword");
		HomePage.btn_login(driver).click();

		String expectedURL6 = "http://localhost:8080/Simple_Login_WebApp/LoginCheck";
		String actualURL6 = "";
		String expectederr6 = "Invalid Credentials!";
		String actualerr6 = "";

		actualURL6 = driver.getCurrentUrl();
		actualerr6 = driver.findElement(By.tagName("body")).getText();

		if (actualURL6.contentEquals(expectedURL6) && expectederr6.contentEquals(actualerr6)) {
			System.out.println("Unsuccessful Login using invalid Password: Test Passed");
		} else {
			System.out.println("Unsuccessful Login using invalid Password: Test Failed");
		}

		driver.close();

	}
}
