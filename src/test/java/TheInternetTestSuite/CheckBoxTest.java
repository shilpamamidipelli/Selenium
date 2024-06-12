package theInternetTestSuite;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest extends BaseTest {

	
	@Test
	public void loadCheckBoxPage() throws Exception {
		Assert.assertEquals(homePage.navigateToCheckBoxPage().checkURL(), true);
	}
	
	@Test
	public void isDefCheckBoxSelected() {
		
	}
	
	@Test
	public void selectBothCheckBox() {
		
	}
	
	
	@Test
	public void deSelectBothCheckBox() {
		
	}
}
