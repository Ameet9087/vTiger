package basicPagePOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.ExcelUtil;
import CommonUtil.JavaUtil;
import CommonUtil.ProperrtyFileUtil;
import CommonUtil.WebDriverUtil;
import ObjectRepository_POM.CreateOrganization;
import ObjectRepository_POM.HomePage;
import ObjectRepository_POM.LoginPage;
import ObjectRepository_POM.OrganizationInfo;

public class test1{
	
	public static  WebDriver driver;
	
public static void main(String[] args) throws InterruptedException, IOException {
	
	ProperrtyFileUtil pfu=new ProperrtyFileUtil();
	ExcelUtil eu=new ExcelUtil();
	WebDriverUtil wdu=new WebDriverUtil();
	JavaUtil ju=new JavaUtil();
	
	//to read data from property file
	String USERNAME = pfu.getDataFromPropertyFile("username");
	String PASSWORD = pfu.getDataFromPropertyFile("password");
	String URL = pfu.getDataFromPropertyFile("url");
	String BROWSER = pfu.getDataFromPropertyFile("Browser");
	
	//to read data from excel file
	String ORGNAME = eu.getDataFromExcel("Organization",0 , 1);
	String GROUP = eu.getDataFromExcel("Organization", 1, 1);
	//to launch the browser
	if (BROWSER.equals("Chrome")) {
		driver=new ChromeDriver();
	} else if(BROWSER.equals("Edge")){
		driver=new EdgeDriver();
	}else {
		driver=new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.get(URL);
    
	//create object of loginPage....
	LoginPage lp=new LoginPage(driver);
	lp.login(USERNAME, PASSWORD);
	//PageFactory.initElements(driver, lp);
//	lp.getUsenametf().sendKeys(USERNAME);
//	lp.getPasswordtf().sendKeys(PASSWORD);
//	lp.getLoginbutton().click();
	
//	//create object of homePage
	HomePage hp=new HomePage(driver);
	hp.home();
	//PageFactory.initElements(driver, hp);
//	//click on organization.....
//	hp.getOrganization().click();
	
	
	//create object of createOrganization page....
	CreateOrganization co=new CreateOrganization(driver);
	co.Organization();
	//PageFactory.initElements(driver, co);
	//click on create organization......
//	co.getCreate().click();
//	
	//create object of organizationInfo page.....
	OrganizationInfo orgInfo=new OrganizationInfo(driver);
	//PageFactory.initElements(driver, orgInfo);
//	//enter organization name in text field.....
//	orgInfo.getOraganizationtf().sendKeys(ORGNAME+ju.getRandomNumber());
	orgInfo.OrganizationInfo(ORGNAME+ju.getRandomNumber(),GROUP);
//	//click on group radio button
//	orgInfo.getGroupbtn().click();
//	//select support group in the drop down
//	wdu.handleDropdown(orgInfo.getDropdown(),GROUP);
//	//click on save button
//	orgInfo.getSave().click();
//	
	Thread.sleep(2000);
//	
//	//mouse hover on image
//	wdu.mouseHover(driver, hp.getImage());
//	
//	//click on sign out button
//    hp.getSigOutButton().click();
	hp.signOut(driver);
	
}	
}
