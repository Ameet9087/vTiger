package POM1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateLeads {

	public WebDriver driver;
	
    //click on create leads
	@FindBy(css = "img[alt='Create Lead...']")
	private WebElement createLeads;

	public CreateLeads(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateLeads() {
		return createLeads;
	}
	
	public LeadsInfo Leads() {
		createLeads.click();
		return new LeadsInfo(driver);
	}
	
}
