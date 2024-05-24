package TheInternetTestSuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TheInternet.ReadConfigPropertiesForInternet;
import TheInternet.TheInternet;

public class BaseTest {

	String browserName = "browserName";
	TheInternet intPage;
	BrowserUtils browserUtil = new BrowserUtils();
	
	@BeforeSuite
	public void initTest() {



		// create the WebDriver objects
		try {
			ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
			intPage = new TheInternet( browserUtil.openBrowser(prop.getProperty(browserName)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterSuite

	public void closeSession() {

	}

}
