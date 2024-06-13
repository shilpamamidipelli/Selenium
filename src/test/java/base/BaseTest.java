package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import DriverFactory.DriverFactory;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
//import org.openqa.selenium.WebDriver;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.b
//import TheInternet.ReadConfigPropertiesForInternet;
import TheInternet.CheckBoxPage;
import TheInternet.HomePage;

public class BaseTest {
	protected DriverFactory df = new DriverFactory();
	protected HomePage homePage;
	protected CheckBoxPage chkPage;
	public static WebDriver driver;
	private static final Logger logger = LogManager.getLogger(BaseTest.class);

	@BeforeSuite

	public void initTest() {
		logger.debug("set up");
		driver = df.openBrowser();
		homePage = new HomePage(driver);
	}

	/*
	 * @BeforeClass public void checkDriverClass() { logger.debug("@BeforeClasss");
	 * //logger.debug(homePage.hashCode()); }
	 *
	 * @BeforeMethod public void checkDriver() { logger.debug("BeforeMethod"); }
	 *
	 * @AfterMethod public void checkDriverAfterMethod() {
	 * logger.debug("Aftermethod "); }
	 */

	/*
	 * @AfterClass public void checkDriverAfterClass() {
	 * logger.debug(homePage.toString()); try {
	 * homePage.navigateToCheckBoxPage().wait(); } catch (InterruptedException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } //logger.debug
	 * logger.debug("after Class"); }
	 */

	@AfterSuite

	public void closeSession() {
		// browserUtil.closeBrowser();
	}

}
