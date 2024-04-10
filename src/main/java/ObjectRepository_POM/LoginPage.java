package ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
	//identify userName textField
	@FindBy(name="user_name")
	private WebElement usenametf;
	
	//identify password textField
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	
	//identify login button
	@FindBy(id="submitButton")
	private WebElement loginbutton;
	
	public WebElement getUsenametf() {
		return usenametf;
	}


	public WebElement getPasswordtf() {
		return passwordtf;
	}


	public WebElement getLoginbutton() {
		return loginbutton;
	}

	//create constructor-initilize web element
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

	//create a method-perform action
	public HomePage login(String usernameData,String passwordData) {
		usenametf.sendKeys(usernameData);
		passwordtf.sendKeys(passwordData);
		loginbutton.click();
		return new HomePage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
