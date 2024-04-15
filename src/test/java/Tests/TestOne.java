package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resource.Base;



public class TestOne extends Base 
{
	WebDriver driver;
	
	@Test 
	public void one() throws IOException, InterruptedException
	{
		System.out.println("Manu started Execution");
		
		System.out.println("Test started and updated into the Github Repository");
		
		System.out.println("Test One Executed");
		
		driver = InitializeBrowser();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		
		Thread.sleep(2000);		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.quit(); 
	}
}
