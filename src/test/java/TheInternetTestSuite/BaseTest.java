package theInternetTestSuite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TheInternet.ReadConfigPropertiesForInternet;
import TheInternet.TheInternet;

public class BaseTest {

	protected TheInternet intPage; 
	protected BrowserUtils browserUtil = new BrowserUtils();

	@BeforeSuite
	public void initTest() {
		// create the WebDriver objects

		try {
			ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
			intPage = new TheInternet( browserUtil.openBrowser(prop.getProperty(ConstantsTest.browserName)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 
	}

	@AfterSuite

	public void closeSession() {
		//browserUtil.closeBrowser();
	}

}
