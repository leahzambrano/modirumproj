package NewUser;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageObjects.HomePage;
import pageObjects.NewUserPage;

public class Unsuccessful_NewUser {


	private static WebDriver driver = null;

	@Test
	public void main() {
		String baseURL = "http://localhost:8080/Simple_Login_WebApp/index.jsp";

		driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//-----------------------------
		//empty fields
		//-----------------------------
		
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL = "";

		actualURL = driver.getCurrentUrl();

		if (actualURL.contentEquals(expectedURL)) {
			NewUserPage.txt_username(driver).sendKeys("");
			NewUserPage.txt_password(driver).sendKeys("");
			NewUserPage.txt_cpass(driver).sendKeys("");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL2 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL2 = "";
		String expectedmsg2 = "Cannot be blank!!";
		String actualmsg2 = "";

		actualURL2 = driver.getCurrentUrl();
		actualmsg2 = driver.findElement(By.tagName("body")).getText();

		if (actualURL2.contentEquals(expectedURL2) && expectedmsg2.contentEquals(actualmsg2)) {
			System.out.println("Unsuccessful New User when empty fields: Test Passed");
		} else {
			System.out.println("Succesful New User when empty fields: Test Failed");
		}

		//-----------------------------
		//empty username
		//-----------------------------
		
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL4 = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL4 = "";

		actualURL4 = driver.getCurrentUrl();

		if (actualURL4.contentEquals(expectedURL4)) {
			NewUserPage.txt_username(driver).sendKeys("");
			NewUserPage.txt_password(driver).sendKeys("pass123");
			NewUserPage.txt_cpass(driver).sendKeys("pass123");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL3 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL3 = "";
		String expectedmsg3 = "Cannot be blank!!";
		String actualmsg3 = "";

		actualURL3 = driver.getCurrentUrl();
		actualmsg3 = driver.findElement(By.tagName("body")).getText();

		if (actualURL3.contentEquals(expectedURL3) && expectedmsg3.contentEquals(actualmsg3)) {
			System.out.println("Unsuccessful New User when Username is empty: Test Passed");
		} else {
			System.out.println("Succesful New User when Username is empty: Test Failed");
		}
		
		//-----------------------------
		//empty password
		//-----------------------------
		
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL5 = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL5 = "";

		actualURL5 = driver.getCurrentUrl();

		if (actualURL5.contentEquals(expectedURL5)) {
			NewUserPage.txt_username(driver).sendKeys("newuser2");
			NewUserPage.txt_password(driver).sendKeys("");
			NewUserPage.txt_cpass(driver).sendKeys("pass123");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL6 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL6 = "";
		String expectedmsg6 = "Cannot be blank!!";
		String actualmsg6 = "";

		actualURL6 = driver.getCurrentUrl();
		actualmsg6 = driver.findElement(By.tagName("body")).getText();

		if (actualURL6.contentEquals(expectedURL6) && expectedmsg6.contentEquals(actualmsg6)) {
			System.out.println("Unsuccessful New User when Password is empty Test Passed");
		} else {
			System.out.println("Succesful New User when Password is empty: Test Failed");
		}
		
		
		//-----------------------------
		//empty confirm password
		//-----------------------------
		
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL7 = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL7 = "";

		actualURL7 = driver.getCurrentUrl();

		if (actualURL7.contentEquals(expectedURL7)) {
			NewUserPage.txt_username(driver).sendKeys("newuser2");
			NewUserPage.txt_password(driver).sendKeys("pass123");
			NewUserPage.txt_cpass(driver).sendKeys("");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL8 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL8 = "";
		String expectedmsg8 = "Cannot be blank!!";
		String actualmsg8 = "";

		actualURL8 = driver.getCurrentUrl();
		actualmsg8 = driver.findElement(By.tagName("body")).getText();

		if (actualURL8.contentEquals(expectedURL8) && expectedmsg8.contentEquals(actualmsg8)) {
			System.out.println("Unsuccessful New User when empty Confirm Password: Test Passed");
		} else {
			System.out.println("Succesful New User when empty Confirm Password: Test Failed");
		}
		
		//-----------------------------
		//incorrect confirm password
		//-----------------------------
		
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL9 = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL9 = "";

		actualURL9 = driver.getCurrentUrl();

		if (actualURL9.contentEquals(expectedURL9)) {
			NewUserPage.txt_username(driver).sendKeys("newuser2");
			NewUserPage.txt_password(driver).sendKeys("pass123");
			NewUserPage.txt_cpass(driver).sendKeys("incorrect");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL10 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL10 = "";
		String expectedmsg10 = "Password confirmation is incorrect!";
		String actualmsg10 = "";

		actualURL10 = driver.getCurrentUrl();
		actualmsg10 = driver.findElement(By.tagName("body")).getText();

		if (actualURL10.contentEquals(expectedURL10) && expectedmsg10.contentEquals(actualmsg10)) {
			System.out.println("Unsuccessful New User when incorrect Confirm Password: Test Passed");
		} else {
			System.out.println("Succesful New User when incorrect Confirm Password: Test Failed");
		}
		
		
		//-----------------------------
		//username already exists
		//-----------------------------
		
		driver.get(baseURL);

		HomePage.lnk_newuser(driver).click();

		String expectedURL11 = "http://localhost:8080/Simple_Login_WebApp/newuser.jsp";
		String actualURL11 = "";

		actualURL11 = driver.getCurrentUrl();

		if (actualURL11.contentEquals(expectedURL11)) {
			NewUserPage.txt_username(driver).sendKeys("admin");
			NewUserPage.txt_password(driver).sendKeys("123");
			NewUserPage.txt_cpass(driver).sendKeys("123");
			NewUserPage.btn_submit(driver).click();
		}

		String expectedURL12 = "http://localhost:8080/Simple_Login_WebApp/NewUser";
		String actualURL12 = "";
		String expectedmsg12 = "Username already exists!";
		String actualmsg12 = "";

		actualURL12 = driver.getCurrentUrl();
		actualmsg12 = driver.findElement(By.tagName("body")).getText();

		if (actualURL12.contentEquals(expectedURL12) && expectedmsg12.contentEquals(actualmsg12)) {
			System.out.println("Unsuccessful New User when Username already exists: Test Passed");
		} else {
			System.out.println("Succesful New User when Username alreay exists: Test Failed");
		}
		
		
		driver.close();

	}

	
	
	
	
}
