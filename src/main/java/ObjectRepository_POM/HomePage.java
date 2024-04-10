package ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.WebDriverUtil;
import POM1.CreateLeads;

public class HomePage extends WebDriverUtil{
	public WebDriver driver;

	//identify the organization element
	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organization;
	
	//identify the contacts element
	@FindBy(xpath="(//a[text()='Contacts'])[1]")
	private WebElement contact;
	
	//click on leads
	@FindBy(xpath = "(//a[text()='Leads'])[1]")
	private WebElement Leads;

	
	
	//identify the image 
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	//identify the sign out 
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement sigOutButton;

	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getContact() {
		return contact;
	}

	public WebElement getLeads() {
		return Leads;
	}
	
	
	
	public WebElement getImage() {
		return image;
	}

	public WebElement getSigOutButton() {
		return sigOutButton;
	}
	
	//create a constructor
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//create a method-organization
	public CreateOrganization home() {
		//click on organization
		organization.click();
		return new CreateOrganization(driver);
	}
	
	//create a method-contacts
		public void homeCont() {
			//click on organization
			contact.click();
		}
		
	//......................leads.......................
	public CreateLeads leads() {
		Leads.click();
		return new CreateLeads(driver);
	}
	
	//hover on sign out
	public LoginPage signOut(WebDriver driver) {
		//mouse hover on image
		mouseHover(driver, image);
		
		//click on sign out button
		sigOutButton.click();
		return new LoginPage(driver);
	}
}
