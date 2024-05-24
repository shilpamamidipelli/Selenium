package TheInternet;

import org.openqa.selenium.WebDriver;

import seleniumsessions.ExceptionHandling;

public class TheInternet {
	UtilityForInternet util ;
	WebDriver driver;
	String URL = "site" ; 
	
	public TheInternet(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver  loadHomePage() throws Exception {		
		 return util.verifyAndLoadURL(ReadConfigPropertiesForInternet.getProp(URL));		
	}
	
	public void performTest() {
		
	}
	


}