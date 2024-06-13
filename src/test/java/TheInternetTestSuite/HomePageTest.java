package theInternetTestSuite;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import base.BaseTest;

public class HomePageTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(HomePageTest.class);

	/**
	 * open browser chrome or ff -- configuration already covered under util Load
	 * the url -- basic url test click on the links as per the input new page is
	 * displayed with the conccept to test test the concept in the link opened if
	 * page is valid close the browser
	 *
	 * @throws Exception
	 */
	/*
	 * @BeforeClass public void OpenHomePage() { homePage = new
	 * HomePage(browserUtil.openBrowser()); }
	 */

	@Test(priority = 1)
	public void OpenPageTest() {
		// System.out.println("1st test");
		logger.debug("HomePage test1");
		try {
			homePage.loadHomePage();
			Assert.assertEquals(homePage.isOnRightURL(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void testPageHeading() {
		// System.out.println("2nd test");
		logger.debug("HomePage test2");
		Assert.assertEquals(homePage.getPageHeading().equals("Welcome to the-internet"), true);
	}

	@AfterClass
	public void call() {
		logger.debug(homePage.checkPagevalue);
		//df.driver = homePage.driver;

	}


}
