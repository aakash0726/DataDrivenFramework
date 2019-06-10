package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static WebDriver driver;

	public void launchBrowser(String BrowserName) {
		if (BrowserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", readPropertiesFile("PathofChromeDriver"));
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("firefox")) {
			// need to write
		} else if (BrowserName.equalsIgnoreCase("ie")) {
			// need to write
		} else {
			System.out.println("Please give proper name of browser");
		}
		
		driver.manage().window().maximize();
	}

	public String readPropertiesFile(String value) {
		Properties prop = new Properties();

		FileInputStream file = null;
		try {
			file = new FileInputStream("TestPorpertiesFile\\VHSTestData.properties");
			prop.load(file);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error is " + e);

		}
		return prop.getProperty(value);

	}

	public void waitFor10Seconds() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void switchToFramwork()
	{
		driver.switchTo().frame(readPropertiesFile("FrameworkName"));
	}

	public void takeScreenshot(String testCaseName)
	{
		try {
			File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("FailScreenshot//"+testCaseName+"_Screenshot.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
