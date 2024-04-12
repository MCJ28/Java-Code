package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resource.Base;

public class listener extends Base implements ITestListener
{
	ExtentReports report = ExtentReport.EReport();
	ExtentTest test;
	String methodname;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	
	
	@Override
	public void onTestStart(ITestResult result)
	{
		methodname = result.getName();
		test = report.createTest(methodname);
		extentTest.set(test); 
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		extentTest.get().log(Status.PASS, methodname+"Test got Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getName();
		
		extentTest.get().fail(result.getThrowable());
		
		WebDriver driver = null;
		
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}
		
		try  
		{
			String DestinationPath = screenshot(methodName, driver);
			
			extentTest.get().addScreenCaptureFromPath(DestinationPath, methodName);
			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
	
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		report.flush();
	}
	
}
