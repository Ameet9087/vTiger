package basicPagePOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtil.ExcelUtil;
import CommonUtil.ProperrtyFileUtil;
import CommonUtil.WebDriverUtil;
import ObjectRepository_POM.HomePage;
import ObjectRepository_POM.LoginPage;
import POM1.Contacts;
import POM1.contactsInfo;

public class test2 {
	public static  WebDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {
	ProperrtyFileUtil pfu=new ProperrtyFileUtil();
    ExcelUtil eu=new ExcelUtil();
    WebDriverUtil wdu=new WebDriverUtil();
		
	String USERNAME = pfu.getDataFromPropertyFile("username");
	String PASSWORD = pfu.getDataFromPropertyFile("password");
	String URL = pfu.getDataFromPropertyFile("url");
    String BROWSER = pfu.getDataFromPropertyFile("Browser");
    
    String FIRSTNAME= eu.getDataFromExcel("Contacts", 0, 1);
    String LASTNAME= eu.getDataFromExcel("Contacts", 1, 1);
    String GROUP = eu.getDataFromExcel("Contacts", 2, 1);
    String ORGNAME = eu.getDataFromExcel("Contacts", 3, 1);
	String CHILDURL = eu.getDataFromExcel("Contacts", 4, 1);
	String PARENTURL = eu.getDataFromExcel("Contacts", 5, 1);

		
		if (BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();
		} else if(BROWSER.equals("Edge")){
			driver=new EdgeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(URL);
	    
		//create object of loginPage
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);
//		PageFactory.initElements(driver, lp);
//		lp.getUsenametf().sendKeys(USERNAME);
//		lp.getPasswordtf().sendKeys(PASSWORD);
//		lp.getLoginbutton().click();
		
		
		//create object of homePage
		HomePage hp=new HomePage(driver);
		hp.homeCont();
//		PageFactory.initElements(driver, hp);
//		hp.getContact().click();
		
		Contacts cont=new Contacts(driver);
		cont.contacts();
//		PageFactory.initElements(driver, contInfo);
//		contInfo.getCreatebtn().click();

		
		contactsInfo contInfo=new contactsInfo(driver);
		contInfo.contactsInformation(FIRSTNAME,LASTNAME,GROUP);	
		contInfo.addOrg(driver, CHILDURL, ORGNAME,PARENTURL);
		
//		contInfo.getFirstname().sendKeys(FIRSTNAME);
//		contInfo.getLastname().sendKeys(LASTNAME);
//		contInfo.getGroup().click();
//		
//		wdu.handleDropdown(contInfo.getDropdown(), GROUP);
//		contInfo.getSave().click();
//		
		Thread.sleep(2000);
//		
//		//mouse hover on image
//		wdu.mouseHover(driver, hp.getImage());
//		
//		//click on sign out button
//	    hp.getSigOutButton().click();
		hp.signOut(driver);
		
	}
}
