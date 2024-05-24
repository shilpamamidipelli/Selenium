package TheInternet;

import org.openqa.selenium.WebDriver;

public class TheInternet {
	UtilityForInternet util ;
	WebDriver driver;
	String URL = "site" ; 
	ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
	
	public TheInternet(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver loadHomePage() throws Exception {
		util = new UtilityForInternet(this.driver);
		return util.verifyAndLoadURL(prop.getProperty(URL));		
	}
	
	public void performTest() {
		
	}
	


}