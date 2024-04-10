package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutionParallel {

	@Test
	public void mintraTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.myntra.com/");
	}
	
	@Test
	public void AjioTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.ajio.com/");
	}
	
	@Test
	public void FaccebookTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com/");
	}
	
	@Test
	public void instagramTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.instagram.com/");
	}
}
