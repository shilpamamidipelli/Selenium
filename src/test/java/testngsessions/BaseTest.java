package testngsessions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class BaseTest {
@BeforeSuite
	
	public void dbConnection() {
		// create the WebDriver objects 
	
		WebDriver drive= null ;
		
	}



@AfterSuite

public void closeSession() {
	
}


}
