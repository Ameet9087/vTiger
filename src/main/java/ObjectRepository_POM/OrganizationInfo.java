package ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.JavaUtil;
import CommonUtil.WebDriverUtil;

public class OrganizationInfo {

	WebDriverUtil wdu=new WebDriverUtil();
	public WebDriver driver;
	
	//identify organization name 
	@FindBy(name="accountname")
	private WebElement oraganizationtf;

	public WebElement getOraganizationtf() {
		return oraganizationtf;
	}
	
	//identify group radio button
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;

	public WebElement getGroupbtn() {
		return groupbtn;
	}
	
	//identify the  dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;

	public WebElement getDropdown() {
		return dropdown;
	}
	
	//identify save button
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement save;

	public WebElement getSave() {
		return save;
	}
	
	//create a constrructor
	public OrganizationInfo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//create a method
	public HomePage OrganizationInfo(String orgname,String group) {
		//enter organization name in text field
		oraganizationtf.sendKeys(orgname);
		//click on group radio button
		groupbtn.click();
		//select support group in the drop down
		wdu.handleDropdown(dropdown, group);
		//click on save button
		save.click();
		return new HomePage(driver);	
	}
	
}
