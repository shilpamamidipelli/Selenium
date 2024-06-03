package theInternetTestSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TheInternetTest extends BaseTest {

	/**
	 * open browser chrome or ff -- configuration already covered under util Load
	 * the url -- basic url test click on the links as per the input new page is
	 * displayed with the conccept to test test the concept in the link opened if
	 * page is valid close the browser
	 */

	@Test
	public void OpenPageTest() {
		System.out.println("1st test");

		if (intPage != null) {
			try {
				Assert.assertEquals(intPage.loadHomePage().getTitle().equals("The Internet"), true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			System.out.println("Some thing is wrong null is given to the internet page");
		}
	}

	@Test
	public void testPageHeading() {
		System.out.println("2nd test");
		Assert.assertEquals(intPage.getPageHeading().equals("Welcome to the-internet"),true);

	}

	@Test

	public void testScrollPageToEnd() {
		System.out.println("3rd test");
		Assert.assertEquals(intPage.scrollToEnd().equals("WYSIWYG Editor"),true);

	}

}
