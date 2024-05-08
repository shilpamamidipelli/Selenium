package seleniumsessions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ElementUtil {
	WebDriver driver;
	
	public ElementUtil(WebDriver driver) {
		 this.driver = driver;
	}
	
	public WebElement getEelement(By locator){
		WebElement ele = driver.findElement(locator) ; 
		return ele ;
	}

	
	public void clickOnLocator(By locator) {
		getEelement(locator).click();
	}
	
	
	public void closeAllWindowsExceptParent(String parentWindowId) throws InterruptedException {
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();

		String WindowHandle = null; 

		
		while(it.hasNext()) {
			WindowHandle = it.next() ;
			driver.switchTo().window(WindowHandle);
			if (WindowHandle.equals(parentWindowId)) {
				System.out.println( WindowHandle + " parent window handle with title " + driver.getTitle());
			}
			else {
				System.out.println("closing child window with id " +WindowHandle  + "and title" + driver.getTitle());
				driver.close();
			}
		}
		driver.switchTo().window(parentWindowId);
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
		Actions act = new Actions(driver); 
		act
			.scrollToElement(getEelement(windowsTestPageLink))
				.click(getEelement(windowsTestPageLink))
					.build()
						.perform();
		
	}
	
}


