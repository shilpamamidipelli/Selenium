package theInternetTestSuite;

import org.apache.logging.log4j.LogManager;
import base.BaseTest;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TheInternet.CheckBoxPage;

public class CheckBoxTest extends BaseTest {
	private static final Logger logger = LogManager.getLogger(CheckBoxTest.class);

	@BeforeClass
	public void call() {

		if(driver ==null ) {
			System.err.println("driver isas null!");

		}
		else {
			chkPage = new CheckBoxPage(driver);
		}


		/*
		 * if (homePage == null) { System.err.println("homePage is null!"); }else {
		 * logger.debug(homePage.checkPagevalue); }
		 */
	}

	@Test(priority = 1)
	public void loadCheckBoxPage()  {
		if (chkPage == null) {
            System.err.println("homePage is null!");
        }else {
        	chkPage.navigateToCheckBoxPage();
    		//Assert.assertEquals(df.navigateToCheckBoxPage(df.driver).checkURL(), true);
        }

	}

	/*
	 * @Test(priority = 2) public void selectFirstCheckBox() {
	 * chkPage.clickFirstCheckBox(); }
	 *
	 * @Test(priority = 3) public void selectSecondCheckBox() {
	 * chkPage.clickSecondCheckBox(); }
	 *
	 * @Test(priority = 4) public void selectBothCheckBox() {
	 * chkPage.clickBothCheckBoxes(); }
	 */

}
