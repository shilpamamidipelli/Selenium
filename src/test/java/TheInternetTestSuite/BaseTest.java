package TheInternetTestSuite;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import TheInternet.ReadConfigPropertiesForInternet;
import TheInternet.TheInternet;

public class BaseTest {

	String browserName = "browserName";
	TheInternet internetPage;

	@BeforeSuite

	public void initTest() {

		BrowserUtils browserUtil = new BrowserUtils();
		WebDriver driver = null;

		// create the WebDriver objects
		try {
			driver = browserUtil.openBrowser(ReadConfigPropertiesForInternet.getProp(browserName));
			internetPage = new TheInternet(driver);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@AfterSuite

	public void closeSession() {

	}

}
