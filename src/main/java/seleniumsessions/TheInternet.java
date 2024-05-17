package seleniumsessions;

import org.openqa.selenium.WebDriver;

public class TheInternet {
	WebDriver driver ;
	String URL = "site" ; 
	String browserName ="browserName";
	public TheInternet(WebDriver driver) {
		this.driver = driver;
	}
	public void loadHomePage() throws Exception {
		
		Utility util = new Utility(driver);
		util.openBrowser(ReadConfigProperties.readProp(browserName));
		util.verifyAndLoadURL(ReadConfigProperties.readProp(URL));
		
	}

// create driver and select the browser from config 

}