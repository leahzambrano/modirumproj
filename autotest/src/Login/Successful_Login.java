package Login;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.HomePage;



public class Successful_Login {


	private static WebDriver driver = null;
	
	@Test
	public void main() {
		String baseURL = "http://localhost:8080/Simple_Login_WebApp/index.jsp";
	
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		
		//successful login
		
		HomePage.txt_username(driver).sendKeys("admin");
		HomePage.txt_password(driver).sendKeys("pass123");
		HomePage.btn_login(driver).click();
		
		String expectedURL = "http://localhost:8080/Simple_Login_WebApp/landingpage.jsp";
		String actualURL = "";
		
		actualURL = driver.getCurrentUrl();
		
		 if (actualURL.contentEquals(expectedURL)){
		        System.out.println("Test Passed!");
		    } else {
		        System.out.println("Test Failed");
		    }
		   
		    driver.close();
		
	
		
	}
}
