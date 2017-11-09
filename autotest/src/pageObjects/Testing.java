package pageObjects;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Testing {

	@Test
	public void LaunchIndexPage() {		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--start-maximized");
		
		WebDriver driver = new ChromeDriver(options);

		
		String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	    String expectedTitle = "Welcome: Mercury Tours";
	    String actualTitle = "";

	    // launch Fire fox and direct it to the Base URL
	    driver.get(baseUrl);

	    // get the actual value of the title
	    actualTitle = driver.getTitle();

	    /*
	     * compare the actual title of the page with the expected one and print
	     * the result as "Passed" or "Failed"
	     */
	    if (actualTitle.contentEquals(expectedTitle)){
	        System.out.println("Test Passed!");
	    } else {
	        System.out.println("Test Failed");
	    }
	   
	    //close Fire fox
	    driver.close();
		
	}
}
