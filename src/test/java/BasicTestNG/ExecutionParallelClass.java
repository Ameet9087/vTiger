package BasicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutionParallelClass {

	//for parallel execution -classes
	
	@Test
	public void AjioTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.skillrary.com/");
	}
	
	@Test
	public void FaccebookTest() {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
}
