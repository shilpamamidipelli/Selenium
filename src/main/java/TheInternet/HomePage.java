package TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomePage {
	UtilityForInternet util;
	WebDriver driver;
	private By pageHeading = By.xpath("//div/h1");
	private By lastLink = By.xpath("//ul/li[last()]/a[contains(text(),'WYS')]");
	private By checkBoxlinkLocator = By.linkText("Checkboxes");

	protected ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
	private static final Logger logger = LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new UtilityForInternet();
	}

	public WebDriver loadHomePage(){
		
		String URL = prop.getProperty(Constants.HomePageURL);
		this.util.verifyURL(URL);
		this.driver.get(URL);		
		return this.driver;
	}

	
	public boolean isOnRightURL() {
		return loadHomePage().getCurrentUrl().equals(Constants.HomePageURL);
	}
	
	public String getPageHeading() {
		return util.getElementText(this.driver, pageHeading);
	}
	
	public CheckBoxPage navigateToCheckBoxPage()  {	
		if(util.ifURLcontains(this.driver, "the-internet.herokuapp.com")) {
			 this.driver = util.scrollToLink(this.driver,checkBoxlinkLocator);
			 util.clickOnElement(this.driver,checkBoxlinkLocator);
			 return new CheckBoxPage(this.driver);
		}
		return null;
	}	

}