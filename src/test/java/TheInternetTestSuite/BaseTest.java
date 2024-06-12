package theInternetTestSuite;

//import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TheInternet.ReadConfigPropertiesForInternet;
import TheInternet.CheckBoxPage;
import TheInternet.HomePage;

public class BaseTest {
	protected BrowserUtils browserUtil = new BrowserUtils();
	protected HomePage homePage; 
	protected CheckBoxPage chkPage; 


	@BeforeSuite
	public void initTest() {
		// create the WebDriver objects
		try {
			ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
			//WebDriver driver = browserUtil.openBrowser(prop.getProperty(ConstantsTest.browserName));
			homePage = new HomePage(browserUtil.openBrowser(prop.getProperty(ConstantsTest.browserNameHomePage)));
	
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
