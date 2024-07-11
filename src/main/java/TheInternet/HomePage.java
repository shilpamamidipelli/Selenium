package TheInternet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Constants.PageConstants; 
import Utils.UtilityForInternet;

public class HomePage {
	public UtilityForInternet util;
	public WebDriver driver;
	private By pageHeading = By.xpath("//div/h1");
	private By lastLink = By.xpath("//ul/li[last()]/a[contains(text(),'WYS')]");

	public String checkPagevalue = "HP";

	protected ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
	private static final Logger logger = LogManager.getLogger(HomePage.class);

	public HomePage(WebDriver driver) {
		this.driver = driver;
		util = new UtilityForInternet();
	}

	public void loadHomePage(){
		String URL = prop.getProperty(PageConstants.HomePageConfig);
		//logger.debug(URL);
		this.util.verifyURL(URL);
		this.driver.get(URL);
		//logger.debug("Open URL check return driver");
	}

	public String getCurrentURL() {
		//logger.debug("get the current URL");
		return this.driver.getCurrentUrl();

	}


	public boolean isOnRightURL() {
		return  getCurrentURL().equals("https://the-internet.herokuapp.com/");
	}

	public String getPageHeading() {
		return util.getElementText(this.driver, pageHeading);
	}




}