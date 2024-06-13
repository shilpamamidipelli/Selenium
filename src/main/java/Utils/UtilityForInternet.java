package Utils;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import TheInternet.ExceptionHandling; 

public class UtilityForInternet {
	//WebDriver utildriver;
	Actions act;
	String headless ;
	WebDriver utildriver;
	public UtilityForInternet() {
		//this.utildriver=driver;
		//this.act = new Actions(driver);
		headless = null;
	}



	public WebDriver scrollToLink(WebDriver utildriver ,By linkName) {

		try {
			scrollToElement(waitAndGetElement(utildriver, linkName));
		} catch (Exception e) {
			scrollToElementJS(utildriver, linkName);
		}
		return utildriver;
	}

	public void scrollToElement(WebElement lastLinkEle) {
		//logger.debug(act);
		act.scrollToElement(lastLinkEle).perform();
		// logger.debug(act);
		// act.moveToElement(this.util.waitAndGetElement(locator)).build().perform();
	}

	public boolean ifURLcontains(WebDriver driver, String str) {
		boolean check = driver.getCurrentUrl().contains("the-internet.herokuapp.com");
		return check;
	}

	private void scrollToElementJS(WebDriver driver, By lastLink) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", waitAndGetElement(driver, lastLink));
	}

	public  void verifyURL(String url ) {
		boolean isNotNull = url != null;
		boolean startsWithHttps = url.startsWith("https://") || url.startsWith("http://");

		if (isNotNull && startsWithHttps) {

		} else {
			throw new ExceptionHandling("Invalid URL");
		}
	}

	public WebElement getEelement(WebDriver utildriver, By locator) {
		WebElement ele = utildriver.findElement(locator);
		return ele;
	}

	public WebElement waitAndGetElement(WebDriver utildriver,By locator) {
		Wait<WebDriver> wait = new WebDriverWait(utildriver, Duration.ofMillis(100))  ;
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> waitAndGetElements(WebDriver utildriver,By locator) {

		Wait<WebDriver> wait = new WebDriverWait(utildriver, Duration.ofMillis(100))  ;
		List<WebElement> list = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		//wait.until(ExpectedConditions.presenceOfElementLocated(locator);
		return list ;
	}

	public void clickOnElement(WebDriver utildriver,By locator) {
		utildriver.findElement(locator).click();
		//getElement(utildriver,locator).click();
	}

	public void closeAllWindowsExceptParent(WebDriver utildriver,String parentWindowId) throws InterruptedException {
		Set<String> handles = utildriver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String WindowHandle = null;

		while (it.hasNext()) {
			WindowHandle = it.next();
			utildriver.switchTo().window(WindowHandle);
			if (WindowHandle.equals(parentWindowId)) {
				System.out.println(WindowHandle + " parent window handle with title " + utildriver.getTitle());
			} else {
				System.out.println("closing child window with id " + WindowHandle + "and title" + utildriver.getTitle());
				utildriver.close();
			}
		}
		utildriver.switchTo().window(parentWindowId);
		/*
		 * Object[] windows = handles.toArray(); String parentwindow = null ;
		 * while(it.hasNext()) { WindowHandle = it.next() ;
		 * driver.switchTo().window(WindowHandle);
		 * if(driver.getCurrentUrl().equalsIgnoreCase(
		 * "https://the-internet.herokuapp.com/windows") ) {
		 * System.out.println(driver.getTitle()); parentwindow = WindowHandle;
		 * System.out.println( parentwindow + " window handle with " +
		 * driver.getTitle()); Thread.sleep(1000); } else if (
		 * driver.getCurrentUrl().equalsIgnoreCase(
		 * "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login") ) {
		 * parentwindow = WindowHandle; System.out.println( parentwindow +
		 * " window handle with " + driver.getTitle()); Thread.sleep(1000); } else {
		 * System.out.println("closing child window " + driver.getTitle());
		 * driver.close(); }
		 *
		 * } if (!parentwindow.isEmpty()) driver.switchTo().window(parentwindow) ; else
		 * System.out.print("No parent window");
		 *
		 *
		 * for (int i = windows.length ; i >=0 ; --i) { if( i-1 > 0 ) {
		 * driver.switchTo().window(windows[i-1].toString());
		 * System.out.println(driver.getTitle()); Thread.sleep(1000); driver.close(); }
		 * if (i==0 ) { driver.switchTo().window(windows[i].toString());
		 * System.out.println(driver.getTitle() + " is the parent window"); }
		 *
		 * }
		 *
		 */

	}
	public String getElementText(WebDriver driver , By locator) {
		String elementText = "NULL";
		try {
			elementText = waitAndGetElement(driver, locator).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementText;
	}

	public void scrollToElement(WebDriver utildriver,By windowsTestPageLink) {
		Actions act = new Actions(utildriver);
		//act.scrollToElement(.build().perform();
	}
}
