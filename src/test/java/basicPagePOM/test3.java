package basicPagePOM;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import CommonUtil.ProperrtyFileUtil;
import ObjectRepository_POM.HomePage;
import ObjectRepository_POM.LoginPage;
import POM1.CreateLeads;

public class test3 {
	public static  WebDriver driver;

	public static void main(String[] args) throws IOException {
		ProperrtyFileUtil pfu=new ProperrtyFileUtil();
		
		String BROWSER = pfu.getDataFromPropertyFile("Browser");
		String URL=pfu.getDataFromPropertyFile("url");
		
		String USERNAME = pfu.getDataFromPropertyFile("username");
		String PASSWORD = pfu.getDataFromPropertyFile("password");
		
		//to launch the browser
		if (BROWSER.equals("Chrome")) {
			driver=new ChromeDriver();
		} else if(BROWSER.equals("Edge")){
			driver=new EdgeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		
		driver.get(URL);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(USERNAME,PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.leads();
		
		CreateLeads l=new CreateLeads(driver);
		l.Leads();
	}
}
