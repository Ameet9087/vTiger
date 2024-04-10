package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class ExecutionParameter {

	//for cross browser execution-executing the test script in more than 2 browser
	
	public WebDriver driver;
	
	@Parameters("Ameet")
	@Test
	public void FaccebookTest(String browser) {
		
		
		
		if (browser.equals("chrome")) {
			driver=new ChromeDriver();
		} else {
			driver=new EdgeDriver();
		}
		driver.get("https://www.skillrary.com/");
	}
	
}
