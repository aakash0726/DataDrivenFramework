package tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Base;
import util.ReadExcelFile;
import util.Utility;

public class LoginTest extends Base {

	private static Logger log = LogManager.getLogger(LoginTest.class.getName());

	@BeforeTest
	public void openBrowser() {
		launchBrowser(readPropertiesFile("Browser"));
	}

	@Test
	public void verifyInvalidLoginValidationMessage() {
		ReadExcelFile readFile = new ReadExcelFile();
		for (int j = 1; j < readFile.totalNumberOfRow(); j++) {
			driver.get(readFile.readExcel(j, readPropertiesFile("ColumnName")));
			Utility u = new Utility();
			u.loginToVHSWithInvalidCredential();
			waitFor10Seconds();
			assertTrue(u.validationMessageForInvalidLoginCredential(), readPropertiesFile("AsertFailMessage"));
			log.info(readFile.readExcel(j, readPropertiesFile("ColumnName2"))
					+ " VHS Website successfully completed verification");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
