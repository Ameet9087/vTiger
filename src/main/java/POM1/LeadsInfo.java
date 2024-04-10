package POM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadsInfo {

	//enter first name
	@FindBy(name = "firstname")
	private WebElement firstName;
	
	//enter last name
	@FindBy(name = "lastname")
	private WebElement lastName;
	
	//compant name
	@FindBy(name = "company")
	private WebElement company;


	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getCompany() {
		return company;
	}
	
	//select group
	@FindBy(xpath = "(//input[@name='assigntype'])[1]")
	private WebElement group;
	
	//select from dropdown
	@FindBy(name = "assigned_group_id")
	private WebElement dropdown;

	public WebElement getGroup() {
		return group;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	
	//click on save button
	@FindBy(xpath = "(//input[@name='button'])[1]")
	private WebElement save;

	public WebElement getSave() {
		return save;
	}
	
	
	public LeadsInfo(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
