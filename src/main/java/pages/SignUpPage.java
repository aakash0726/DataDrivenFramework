package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
public WebDriver driver;
	
	public SignUpPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	//Login in now link
	@FindBy(linkText = "Log in now")
	WebElement LoginInNowLink;
	
	//Username Text Box
	@FindBy(id="username")
	WebElement userNameField;
	
	//First Name Text Box
	@FindBy(id="first_name")
	WebElement firstNameField;
	
	//Last Name Text Box
	@FindBy(id="last_name")
	WebElement lastNameField;
	
	//Email Text Box
	@FindBy(id="email")
	WebElement emailField;
	
	//Phone Number Field
	@FindBy(id="phone_number")
	WebElement phoneNumberField;
	
	//Password Field
	@FindBy(id="passw1")
	WebElement password1Field;
	
	//Repeat Password Field
	@FindBy(id="passw2")
	WebElement password2Field;
	
	//Check box of send these credential via email
	@FindBy(name ="send_credentials_via_email")
	WebElement sendCredentialCheckBox;
	
	//register submit button
	@FindBy(id="register")
	WebElement registerButton;
	
	//Signup Password error message
	@FindBy(id ="passErr")
	WebElement signUpPasswordErrorMessage;
	
	//Sign up Confirm Password error message
	@FindBy(id = "pass2Err")
	WebElement signUpConfirmPasswordErrorMessage;
	
	public WebElement loginInNowLink()
	{
		return LoginInNowLink;
	}

	public WebElement enterUserName()
	{
		return userNameField;
	}

	public WebElement enterFirstName()
	{
		return firstNameField;
	}

	public WebElement enterLastName()
	{
		return lastNameField;
	}
	
	public WebElement enterEmail()
	{
		return emailField;
	}

	public WebElement enterPhoneNumber()
	{
		return phoneNumberField;
	}
	
	public WebElement enterPassword()
	{
		return password1Field;
	}

	public WebElement enterConfirmPassword()
	{
		return password2Field;
	}

	public WebElement sendMeCredentialViaEmailCheckBox()
	{
		return sendCredentialCheckBox;
	}

	public WebElement registerLink()
	{
		return registerButton;
	}

	public WebElement validationMessageOnSignUpForPassword()
	{
		return signUpPasswordErrorMessage;
	}

	public WebElement validationMessageOnSignUpForConfirmPassword()
	{
		return signUpConfirmPasswordErrorMessage;
	}
	
}
