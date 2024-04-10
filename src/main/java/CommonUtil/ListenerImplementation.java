package CommonUtil;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementation implements ITestListener{
	
	ExtentReports report;
	JavaUtil ju=new JavaUtil();
	ExtentTest test;
	WebDriverUtil wdu=new WebDriverUtil();
	
	
	@Override
	public void onTestStart(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+" TestScript execution is started :",true);
		test=report.createTest(methodName);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		//Reporter.log(methodName+"TestScript execution is success",true);
	    test.log(Status.PASS, "TestScript execution is success");
	    
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String message= result.getThrowable().toString();
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+" TestScript execution is failure :"+message,true);
		test.log(Status.FAIL, "TestScript execution is failed");
		
		try {
			String path = wdu.screenshot(baseClass.sdriver, "contact");
			test.addScreenCaptureFromPath(path);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		Reporter.log(methodName+"TestScript execution is skipped",true);
		test.log(Status.SKIP, "TestScript execution is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		Reporter.log("TestScript execution is started",true);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		Reporter.log("TestScript execution is started",true);
	}

	@Override
	public void onStart(ITestContext context) {
		//Reporter.log(" execution is started",true);
		
		//use extentsparkReporter class just to configure extent report
		ExtentSparkReporter reporter=new ExtentSparkReporter("./ExtentReport/report"+ju.getRandomNumber()+".html");
		reporter.config().setDocumentTitle("vTigercrm");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Organization");
		
		//use extentReporter class to generate extend report
	    report=new ExtentReports();
		report.attachReporter(reporter);
		report.setSystemInfo("OS", "Window 10");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Chromeversion", "120");
		report.setSystemInfo("Author", "Ameet Singh");
	
		
	}
	
	
	@Override
	public void onFinish(ITestContext context) {
		//Reporter.log(" execution is finished",true);
		
		report.flush();
		test.log(Status.PASS, "TestScript execution is success");
	}

	
}
