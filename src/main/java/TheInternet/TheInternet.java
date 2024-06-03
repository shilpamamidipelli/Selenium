package TheInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TheInternet {
	UtilityForInternet util;
	WebDriver driver;
	protected Actions act;
	protected By pageHeading = By.xpath("//div/h1");
	protected By lastLink = By.xpath("//ul/li[last()]/a[contains(text(),'WYS')]");

	protected ReadConfigPropertiesForInternet prop = new ReadConfigPropertiesForInternet();
	private static final Logger logger = LogManager.getLogger(TheInternet.class);

	public TheInternet(WebDriver driver) {
		this.driver = driver;
		this.util = new UtilityForInternet(driver);
		this.act = new Actions(this.driver);
	}

	public WebDriver loadHomePage() throws Exception {
		return this.util.verifyAndLoadURL(prop.getProperty(ConstantsPage.URLProp));
	}

	public WebDriver selectCheckboxpage(String testPageName) {
		return this.util.verifyAndLoadURL(testPageName);

	}

	public String getElementText(By locator) {
		String elementText = "NULL";
		try {
			elementText = this.util.waitAndGetElement(locator).getText();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return elementText;
	}

	public String getPageHeading() {
		return getElementText(pageHeading);
	}

	public String scrollToEnd() {
		// logger.debug(this.util.waitAndGetElement(lastLink));
		try {
			scrollToElement(this.util.waitAndGetElement(lastLink));
		} catch (Exception e) {
			scrollToElementJS(this.util.driver, lastLink);
		}
		// logger.debug(act);
		return getElementText(lastLink);
	}

	public void scrollToElement(WebElement lastLinkEle) {
		// logger.debug(act);
		act.scrollToElement(lastLinkEle).perform();
		// logger.debug(act);
		// act.moveToElement(this.util.waitAndGetElement(locator)).build().perform();
	}

	private void scrollToElementJS(WebDriver driver, By lastLink) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", this.util.waitAndGetElement(lastLink));
	}

	public WebDriver getDriver() {
		return this.driver;
	}
}