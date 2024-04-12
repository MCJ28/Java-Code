package Resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base  
{
	WebDriver driver;
	public Properties ps;
	
	public WebDriver InitializeBrowser() throws IOException
	{
		
		ps = new Properties();
		
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\BrowserData.properties";
		
		FileInputStream fis = new FileInputStream(path);
		ps.load(fis);
		
		String BrowserName = ps.getProperty("Browser"); 
				
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("InternetExplorer"))
		{
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		return driver;
	}
	
	
		
		public String screenshot(String LogInTest, WebDriver driver) throws IOException
		{
			File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String Screenshotpath = System.getProperty("user.dir")+"\\screenshot\\"+LogInTest+".png";
			FileUtils.copyFile(screenshot, new File(Screenshotpath)); 
			
			return Screenshotpath; 
			
		} 
	 
	
	
}
