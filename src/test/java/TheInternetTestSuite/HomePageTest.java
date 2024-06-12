package theInternetTestSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

	/**
	 * open browser chrome or ff -- configuration already covered under util Load
	 * the url -- basic url test click on the links as per the input new page is
	 * displayed with the conccept to test test the concept in the link opened if
	 * page is valid close the browser
	 * @throws Exception 
	 */

	@Test(priority = 1)
	public void OpenPageTest()  {
		System.out.println("1st test");
		try {
			Assert.assertEquals(homePage.isOnRightURL(), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void testPageHeading() {
		System.out.println("2nd test");
		Assert.assertEquals(homePage.getPageHeading().equals("Welcome to the-internet"),true);
	}

}
