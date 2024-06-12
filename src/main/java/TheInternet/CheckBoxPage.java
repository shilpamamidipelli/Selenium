package TheInternet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBoxPage {

	
	 WebDriver driver ; 
	 UtilityForInternet util;
	private By pageheading = By.xpath("//div/ul/li[contains[text(),\"Checkboxes\"]");
	private By isChecked = By.xpath("//input[@type='checkbox' and @checked='checked']");
	private By checBoxEle = By.xpath("//input[@type='checkbox']");
	public CheckBoxPage(WebDriver driver) { 
		this.driver = driver;
		this.util = new UtilityForInternet();
	}
	
	public boolean checkURL() {
		if (this.driver.getCurrentUrl().contains("CheckBoxes")) {
			 return true;
		}
		return false;
	}
	
	public void clickUncheckedCheckBox() {
		
		
		
	}
	
	public String getWhichCheckBoxisSelected(List<WebElement> chkboxes) {
		
		String checkBoxeStatus = null;
		int count =0;
			for(int i=0; i<chkboxes.size(); ++i) {
				if(chkboxes.get(i).findElement(isChecked).isSelected()) {
					if(i==0)
						checkBoxeStatus = "first";
					else if(i==1 & !checkBoxeStatus.equals("first") )
						checkBoxeStatus = "only second";
					else if(i==1 & checkBoxeStatus.equals("first") )
						checkBoxeStatus = "both";
				}	
			}
			return checkBoxeStatus;
	}
	
	public void clickFirstCheckBox() {
		List<WebElement> chkboxes = util.waitAndGetElements(this.driver, checBoxEle);
		String checkBoxeStatus = getWhichCheckBoxisSelected(chkboxes);
		
		if (checkBoxeStatus.equals("both")){
			chkboxes.get(0).findElement(checBoxEle).click(); // unselect first and second checkboxes and select agan
			chkboxes.get(1).findElement(checBoxEle).click();
			chkboxes.get(0).findElement(checBoxEle).click();
		}
		if(checkBoxeStatus.equals("only second") ){
			chkboxes.get(1).findElement(checBoxEle).click(); // un select first 
			chkboxes.get(0).findElement(checBoxEle).click();
		}
	}
	
	public void clickSecondCheckBox() {
		List<WebElement> chkboxes = util.waitAndGetElements(this.driver, checBoxEle);
		String checkBoxeStatus = getWhichCheckBoxisSelected(chkboxes);

		if (checkBoxeStatus.equals("both")){
			chkboxes.get(0).findElement(checBoxEle).click(); // unselect first and second checkboxes and select agan
			chkboxes.get(1).findElement(checBoxEle).click();
			chkboxes.get(1).findElement(checBoxEle).click();
		}
		if(checkBoxeStatus.equals("first")){
			chkboxes.get(0).findElement(checBoxEle).click(); // un select first 
			chkboxes.get(1).findElement(checBoxEle).click();
			
		}	
		
	}
	
	public void clickBothCheckBoxes() {
		List<WebElement> chkboxes = util.waitAndGetElements(this.driver, checBoxEle);
		String checkBoxeStatus = getWhichCheckBoxisSelected(chkboxes);

		if(checkBoxeStatus.equals("first")){
			//chkboxes.get(0).findElement(checBoxEle).click(); // un select first 
			chkboxes.get(1).findElement(checBoxEle).click();
			
		}	
		if(checkBoxeStatus.equals("only second") ){
			//chkboxes.get(1).findElement(checBoxEle).click(); // un select first 
			chkboxes.get(0).findElement(checBoxEle).click();
		}
	}
}
