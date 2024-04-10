package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutionGroup {

	@Test(groups = "shopping")
	public void mintraTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
	}
	
	@Test(groups = "shopping")
	public void AjioTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
	}
	
	@Test(groups = "social media")
	public void FaccebookTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test(groups = "social media")
	public void instagramTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
	}
	
}
