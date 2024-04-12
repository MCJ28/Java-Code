package LogInTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage 
{
	WebDriver driver;
	
	public LogInPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="input-email")
	private WebElement Emailfield; 
	
	@FindBy(id="input-password")
	private WebElement Passwordfield;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement LoginOption;
	
	
	public WebElement Emailfield()
	{
		return Emailfield;  
	}
	
	public WebElement Passwordfield()
	{
		return Passwordfield;
	}
	
	public WebElement LoginOption()
	{
		return LoginOption;
	} 
}
