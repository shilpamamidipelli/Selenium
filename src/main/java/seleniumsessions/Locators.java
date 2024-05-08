package seleniumsessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangehrm.com/en/30-day-free-trial/");

		// id

		driver.findElement(By.id("Form_getForm_subdomain")).sendKeys("Test" + System.currentTimeMillis());
		// name

		driver.findElement(By.name("Name")).sendKeys("Shilpa" + System.currentTimeMillis());
		// driver.findElement(By.id("Form_getForm_Name")).sendKeys("Shilpa"+System.currentTimeMillis());

		// class name
		//driver.findElement(By.className("email text")).sendKeys("Shilpa" + System.currentTimeMillis() + "@gmail.com");
		// driver.findElement(By.id("Form_getForm_Email")).sendKeys("Shilpa"+System.currentTimeMillis()+"@gmail.com");
		
		// css 
		//driver.findElement(By.cssSelector(""));
		driver.findElement(By.id("Form_getForm_Contact")).sendKeys("9441731171");

		// xpath
		driver.findElement(By.xpath("//select[@name='Country']/option[4]")).click();

	}

}
