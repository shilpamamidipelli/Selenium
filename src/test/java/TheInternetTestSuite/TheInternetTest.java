package TheInternetTestSuite;

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
		try {
			Assert.assertEquals(internetPage.loadHomePage().getTitle().equalsIgnoreCase("theinternet"), true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test

	public void testLinkTest() {

	}

	@Test

	public void NavigateTest() {

	}

}
