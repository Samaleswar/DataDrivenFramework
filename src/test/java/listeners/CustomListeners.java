package listeners;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import base.testBase;
import utilities.ExtentManager;

public class CustomListeners extends testBase implements ITestListener {
	public static ExtentTest test;
	ExtentReports extent=ExtentManager.getReportObject();
	public static ThreadLocal<ExtentTest> extentTest =new ThreadLocal<ExtentTest>();
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test= extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//extentTest.get().log(Status.PASS, "Test Passed");
		//ITestListener.super.onTestSuccess(result);
		extentTest.get().log(Status.PASS, "Test passed");
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//Screenshot
		extentTest.get().fail(result.getThrowable());
		extentTest.get().log(Status.FAIL, "Test Failed.");
		
		/*WebDriver driver =null;
		String testMethodName =result.getMethod().getMethodName();
		
		try {
			extentTest.get().addScreenCaptureFromPath(getScreenShotPath(testMethodName, driver));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	}

}
