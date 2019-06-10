package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderLink {

public WebDriver driver;
	
	public HeaderLink(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//*[@id='menu-item-153']/a")
	WebElement HeaderLoginLink;

	// HeaderLoginLink
	public WebElement headerLoginLink() {
		return HeaderLoginLink;
	}

}
