package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resource.Base;
 
public class TestTwo extends Base 
{
WebDriver driver;
	
	@Test
	public void two() throws IOException, InterruptedException
	{
		System.out.println("Test Two Executed");
		
		driver = InitializeBrowser();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		
		Assert.assertTrue(false);
		
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void closure()
	{
		driver.quit();
	} 
		
	
}
