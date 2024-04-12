package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LogInTests.AccountPage;
import LogInTests.LandingPage;
import LogInTests.LogInPage;
import Resource.Base;



public class Login extends Base 
{
	WebDriver driver;
	Logger logs;
		 
	@Test(dataProvider = "DataDriven")
	public void tutorials(String Email, String Password, String ExpectedResult) throws IOException, InterruptedException
	{
		logs = LogManager.getLogger(Login.class);
		
		driver = InitializeBrowser();
		logs.debug("Browser has launched");
		
		driver.get(ps.getProperty("URL"));
		logs.debug("URL has opened");
		
		LandingPage lp = new LandingPage(driver); 
		lp.MyAccount().click();
		logs.debug("MY Account Dropdown has clicked");
		
		lp.LoginOption().click();
		logs.debug("LogIn Option has clicked");
		
		Thread.sleep(1000);
		
		LogInPage lp2 = new LogInPage(driver);
		lp2.Emailfield().sendKeys(Email);
		logs.debug("Email has enetered into the required field");
		
		lp2.Passwordfield().sendKeys(Password);
		logs.debug("Password has enetered into the required field");
		
		lp2.LoginOption().click(); 
		logs.debug("LogIn Button has clicked");
		
		Thread.sleep(1000);
		
		AccountPage lp3 = new AccountPage(driver); 
		
		String ActualResult = null;
		
		try
		{
			if(lp3.AccountSuccessOption().isDisplayed())
			{
				ActualResult = "Succesful";
				logs.info("User has succesfully LoogedIn");
				
			}
		}
		
		catch(Exception e)
		{ 
			ActualResult = "Failure";
			logs.error("User loggedIn has Failed");
			
		}
		
		Assert.assertEquals(ActualResult, ExpectedResult);
		logs.info("Login Test got Passed");	
	}
	
	@AfterMethod 
	public void closure()
	{
		driver.quit();
		logs.debug("Browser has closed");
	}
	
	  
	@DataProvider 
	public Object[][] DataDriven()
	{
		Object ar[][] = {{"manojcj@gmail.com", "12345", "Succesful"}, {"manoj151@yahoo.com", "651645dduvb", "Failure"}};
		
		return ar;
				 
	}
}
 