package StepDefinition;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import LogInTests.AccountPage;
import LogInTests.LandingPage;
import LogInTests.LogInPage;
import Resource.Base;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends Base
{
	WebDriver driver;
	LogInPage lp2;
	LandingPage lp;
	
	@Given("^I Opened the TutorialsNinja Appliccation$")
	public void I_Opened_the_TutorialsNinja_Appliccation() throws IOException
	{
		driver = InitializeBrowser();
		driver.get(ps.getProperty("URL"));
	}
	
	@And("^I Navigate to the Login Page$")
	public void I_Navigate_to_the_Login_Page() throws InterruptedException
	{
		lp = new LandingPage(driver); 
		lp.MyAccount().click();
		lp.LoginOption().click(); 
		
		Thread.sleep(1000);
	}
	
	@When("^User should enter the Email as \"(.*)\" and Password as \"(.*)\" into the fields$")
	public void User_should_enter_the_Email_as_email_and_Password_as_password_into_the_fields(String Email, String Password)
	{
		lp2 = new LogInPage(driver);
		lp2.Emailfield().sendKeys(Email);
		lp2.Passwordfield().sendKeys(Password);
	}
	
	@And("^User should click on the Login button$")
	public void User_should_click_on_the_Login_button()
	{
		lp2.LoginOption().click(); 
	}
	
	@Then("^User should Login based on the credentials$")
	public void User_should_Login_based_on_the_credentials()
	{
		AccountPage lp3 = new AccountPage(driver); 
		
		Assert.assertTrue(lp3.AccountSuccessOption().isDisplayed());
	}	
	
	
	@After
	public void closure()
	{
		driver.quit();
	}
}
