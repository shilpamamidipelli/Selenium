package seleniumsessions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.interactions.Actions;

public class Utility {
	WebDriver driver;
	
	String headless ;
	public Utility(WebDriver driver) {
		this.driver = driver;
		headless = null;
	}

	@SuppressWarnings("null")
	public void openBrowser(String browserName) throws Exception {
		 
		try {
			headless = ReadConfigProperties.readProp("headless");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		switch (browserName) {
		case "chrome":
			ChromeOptions co = new ChromeOptions();
			if (headless.equalsIgnoreCase("headless")) {
				co.addArguments("--headless");
			}
			this.driver = new ChromeDriver(co);
			break;
		case "Edge":
			EdgeOptions eo = new EdgeOptions();
			if (headless.equalsIgnoreCase("headless")) {
				eo.addArguments("--headless");
			}

			this.driver = new EdgeDriver(eo);
			break;
		case "FireFox":
			FirefoxOptions fo = new FirefoxOptions();
			if (headless.equalsIgnoreCase("headless")) {
				fo.addArguments("--headless");
			}

			this.driver = new FirefoxDriver(fo);
			break;
		case "Safari":

			SafariOptions so = new SafariOptions();

			if (headless.equalsIgnoreCase("headless")) {
				so.setCapability("headless", headless);
			}

			this.driver = new SafariDriver(so);
			break;
		default:
			throw new ExceptionHandling("Please give chrome / edge / firefox / Safari as browser name");
		}
		this.driver.manage().deleteAllCookies();
		this.driver.manage().window().maximize();
	}

	
	public  void verifyAndLoadURL(String url) {
		boolean isNotNull = url != null;
		boolean startsWithHttps = url.startsWith("https://") || url.startsWith("http://");
		if (isNotNull && startsWithHttps) {
			this.driver.get(url);
		} else {
			throw new ExceptionHandling("Invalid URL");
		}

	}

	public WebElement getEelement(By locator) {
		WebElement ele = this.driver.findElement(locator);
		return ele;
	}

	public void clickOnLocator(By locator) {
		getEelement(locator).click();
	}

	public void closeAllWindowsExceptParent(String parentWindowId) throws InterruptedException {
		Set<String> handles = this.driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String WindowHandle = null;

		while (it.hasNext()) {
			WindowHandle = it.next();
			this.driver.switchTo().window(WindowHandle);
			if (WindowHandle.equals(parentWindowId)) {
				System.out.println(WindowHandle + " parent window handle with title " + driver.getTitle());
			} else {
				System.out.println("closing child window with id " + WindowHandle + "and title" + driver.getTitle());
				this.driver.close();
			}
		}
		this.driver.switchTo().window(parentWindowId);
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

	public void scrollToElement(By windowsTestPageLink) {
		Actions act = new Actions(this.driver);
		act.scrollToElement(getEelement(windowsTestPageLink)).click(getEelement(windowsTestPageLink)).build().perform();

	}

}
