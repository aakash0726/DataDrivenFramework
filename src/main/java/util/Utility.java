package util;

import pages.HeaderLink;
import pages.LoginPage;
import pages.SignUpPage;

public class Utility extends Base {

	LoginPage lp = new LoginPage(driver);
	HeaderLink hl = new HeaderLink(driver);
	SignUpPage sp = new SignUpPage(driver);

	public void clickingOnheaderLoginLink() {
		hl.headerLoginLink().click();
	}

	public void clickingOnLoginButton() {
		lp.submit().click();
	}

	public void clickingOnForgotPasswordLinkFromLoginPage() {
		lp.forgotPassword().click();
	}

	public void clickingOnSignUpLinkFromLoginPage() {
		lp.signup().click();
	}

	public void clickingOnLoginInNowLinkFromSignUpPage() {
		sp.loginInNowLink().click();
	}

	public void clickOnRegisterButtonOnSignUpPage() {
		sp.registerLink().click();
	}

	public void selectingCheckBoxForSendCredentialsViaEmail() {
		sp.sendMeCredentialViaEmailCheckBox().click();
	}

	public void signUpToVHSWithWrongPasswordFormat() {
		switchToFramwork();
		clickingOnheaderLoginLink();
		clickingOnSignUpLinkFromLoginPage();
		sp.enterUserName().sendKeys(readPropertiesFile("SignUpUsername"));
		sp.enterFirstName().sendKeys(readPropertiesFile("SignUpFirstName"));
		sp.enterLastName().sendKeys(readPropertiesFile("SignUpLastName"));
		sp.enterEmail().sendKeys(readPropertiesFile("SignUpEmail"));
		sp.enterPhoneNumber().sendKeys(readPropertiesFile("SignUpPhoneNumber"));
		sp.enterPassword().sendKeys(readPropertiesFile("WrongFormatSignUpPassword"));
		sp.enterConfirmPassword().sendKeys(readPropertiesFile("WrongFormatSignUpPassword"));
		clickOnRegisterButtonOnSignUpPage();

	}

	public boolean validationMessageForWrongFormatPassword() {
		return sp.validationMessageOnSignUpForPassword().getText()
				.equalsIgnoreCase(readPropertiesFile("WrongFormatPasswordValidationTextOnPasswordField"));
	}

	public void signUpToVHSWithNotSamePasswordFormat() {
		switchToFramwork();
		clickingOnheaderLoginLink();
		clickingOnSignUpLinkFromLoginPage();
		sp.enterUserName().sendKeys(readPropertiesFile("SignUpUsername"));
		sp.enterFirstName().sendKeys(readPropertiesFile("SignUpFirstName"));
		sp.enterLastName().sendKeys(readPropertiesFile("SignUpLastName"));
		sp.enterEmail().sendKeys(readPropertiesFile("SignUpEmail"));
		sp.enterPhoneNumber().sendKeys(readPropertiesFile("SignUpPhoneNumber"));
		sp.enterPassword().sendKeys(readPropertiesFile("WrongFormatSignUpPassword"));
		sp.enterConfirmPassword().sendKeys(readPropertiesFile("NotSameSignUpPassword"));
		clickOnRegisterButtonOnSignUpPage();
	}

	public boolean validationMessageForNotSamePassword() {
		return sp.validationMessageOnSignUpForConfirmPassword().getText()
				.equalsIgnoreCase(readPropertiesFile("NotSamePasswordValidationTextOnConfirmPasswordField"));
	}

	public void loginToVHSWithInvalidCredential() {
		switchToFramwork();
		clickingOnheaderLoginLink();
		lp.enterUserName().sendKeys(readPropertiesFile("invalidUsername"));
		lp.enterPassword().sendKeys(readPropertiesFile("Invalidpassword"));
		clickingOnLoginButton();

	}

	public boolean validationMessageForInvalidLoginCredential() {
		return lp.validationMessageOnLogin().getText()
				.equalsIgnoreCase(readPropertiesFile("ValidationMessageForInvalidCredentialOnLogin"));
	}

}
