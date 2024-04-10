package ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contacts {

	//click on create button
		@FindBy(css = "img[alt='Create Contact...']")
		private WebElement createbtn;

		public WebElement getCreatebtn() {
			return createbtn;
		}
	
	//create constructor
	public Contacts(WebDriver driver) {
		//initalize the element
		PageFactory.initElements(driver, this);
	}
	
	//create contacts
	public void contacts() {
		//click on contacts
		createbtn.click();
	}
	
	
	
	
	
	
	
}
