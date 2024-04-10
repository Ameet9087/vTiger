package ObjectRepository_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.WebDriverUtil;

public class contactsInfo {
	
	WebDriverUtil wdu=new WebDriverUtil();
	
	@FindBy(name = "firstname")
	private WebElement firstname;
	
	@FindBy(name="lastname")
	private WebElement lastname;

	public WebElement getFirstname() {
		return firstname;
	}

	public WebElement getLastname() {
		return lastname;
	}
	
	@FindBy(xpath = "(//input[@name='assigntype'])[2]")
	private WebElement group;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;

	public WebElement getGroup() {
		return group;
	}

	public WebElement getDropdown() {
		return dropdown;
	}
	
	//identify save button
		@FindBy(xpath = "(//input[@name='button'])[1]")
		private WebElement save;

		public WebElement getSave() {
			return save;
		}
	
    //click on add organization
	@FindBy(xpath = "(//img[@alt='Select'])[1]")
	private WebElement addIcon;
	

		public WebElement getAddIcon() {
		return addIcon;
	}


	//search on child page
		@FindBy(id = "search_txt")
		private WebElement searchtf;
		
		public WebElement getSearch() {
			return searchtf;
		}
		
	//click on search icon
		@FindBy(name = "search")
		private WebElement searchIcon;
		
       public WebElement getSearchIcon() {
			return searchIcon;
		}
       //select organization
       @FindBy(id="1")
       private WebElement selectFirst;
       

		public WebElement getSelectFirst() {
		return selectFirst;
	}

		//.............................................................................
		//create constructor
		public contactsInfo(WebDriver driver) {
			//initalize the element
			PageFactory.initElements(driver, this);
		}
		
		//create the method
		public void contactsInformation(String firstnametf,String lastnametf,String Selectgroup) {
			firstname.sendKeys(firstnametf);
			lastname.sendKeys(lastnametf);
			group.click();
			wdu.handleDropdown(dropdown, Selectgroup);
			
		}
		
		//add organization
		public void addOrg(WebDriver driver,String c_url,String org,String p_url) {
			addIcon.click();
			wdu.switchWindow(driver, c_url);
			searchtf.sendKeys(org);
			searchIcon.click();
			selectFirst.click();
			wdu.switchWindow(driver, p_url);
			save.click();
			
		}
		
		
		
		
		
}
