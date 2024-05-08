package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://the-internet.herokuapp.com/dropdown");
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
		Select sdrop = new Select(dropdown);
		sdrop.selectByVisibleText("Option 1");
		Thread.sleep(1000);
		sdrop.selectByValue("2");
		Thread.sleep(1000);
		//sdrop.selectByIndex(2);
		//Thread.sleep(1000);
		
		List<WebElement> options = driver.findElements(By.tagName("option"));
		
		for (WebElement dropdownopt :  options) {
			System.out.println("inside the loop" + dropdownopt.getText());
			if(dropdownopt.getText().equals("Option 1") ){
				System.out.println("found the Option 1");
				dropdownopt.click();
				Thread.sleep(1000);
			}
		}
		
		driver.quit();
	}

}
