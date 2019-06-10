package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Sign up link
	@FindBy(linkText = "Sign Up")
	WebElement signUpLink;
	
	//Username Textbox
	@FindBy(id = "username")
	WebElement userName;
	
	//Password Textbox
	@FindBy(id ="password")
	WebElement passWord;
	
	//Login Button 
	@FindBy(name = "login")
	WebElement loginButton;
	
	//Check box for remember me
	@FindBy(name="rememberme")
	WebElement remembermeBox;
	
	//Forgot Password link
	@FindBy(linkText = "Lost your password?")
	WebElement forgotPassword;
	
	//Validation Message on login page
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li")
	WebElement loginValdiationMessage;
	
	public WebElement enterUserName()
	{
		return userName;
	}
	
    public WebElement enterPassword()
	{
		return passWord;
	}
    
    public WebElement submit()
    {
    	return loginButton;
    }

    public WebElement rememberMeCheckBox()
    {
    	return remembermeBox;
    }

    public WebElement forgotPassword()
    {
    	return forgotPassword;
    }

    public WebElement signup()
    {
    	return signUpLink;
    }
    
    public WebElement validationMessageOnLogin()
    {
    	return loginValdiationMessage;
    }
    
}
