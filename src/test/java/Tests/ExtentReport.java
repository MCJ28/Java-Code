package Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport
{
	static ExtentReports er;
	
	public static ExtentReports EReport()
	{
		String path = System.getProperty("user.dir")+"\\ExtentReport\\index.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(path);
		esr.config().setReportName("Automation Test Result");
		esr.config().setDocumentTitle("Test Document Report");
		
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Operating System", "windows 10");
		er.setSystemInfo("Tested By", "Manu");
		
		return er; 
	}
} 



 

