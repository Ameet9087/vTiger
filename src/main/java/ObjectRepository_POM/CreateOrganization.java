package ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganization {
	public WebDriver driver;

	//identinfy create organization
	@FindBy(css = "img[alt='Create Organization...']")
	private WebElement create;

	public WebElement getCreate() {
		return create;
	}
	
	//click on create organization
	
	//create a constructor
	public CreateOrganization(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//create method
		public OrganizationInfo Organization() {
			//click on create organization
			create.click();
			return new OrganizationInfo(driver);
		}
}
