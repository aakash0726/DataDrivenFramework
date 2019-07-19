package tests;

import static org.testng.Assert.assertTrue;

import org.apache.logging.log4j.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import util.Base;
import util.ReadExcelFile;
import util.Utility;

public class SignUpTest extends Base {
	private static Logger log = LogManager.getLogger(SignUpTest.class.getName());

	@BeforeTest
	public void openBrowser() {
		launchBrowser(readPropertiesFile("Browser"));
	}

	@Test(priority = 1)
	public void verifyInvalidPasswordValidationMessage() {
		ReadExcelFile readFile = new ReadExcelFile();
		for (int j = 1; j < readFile.totalNumberOfRow(); j++) {
			driver.get(readFile.readExcel(j, readPropertiesFile("ColumnName")));
			Utility u = new Utility();
			u.signUpToVHSWithWrongPasswordFormat();
			assertTrue(u.validationMessageForWrongFormatPassword(), readPropertiesFile("AsertFailMessage"));
			log.info(readFile.readExcel(j, readPropertiesFile("ColumnName2"))
					+ " VHS Website successfully completed verification");

		}
	}

	@Test(priority = 2)
	public void verifyNotSamePasswordValidationMessage() {
		ReadExcelFile readFile = new ReadExcelFile();
		for (int j = 1; j < readFile.totalNumberOfRow(); j++) {
			driver.get(readFile.readExcel(j, readPropertiesFile("ColumnName")));
			Utility u = new Utility();
			u.signUpToVHSWithNotSamePasswordFormat();
			assertTrue(u.validationMessageForNotSamePassword(),readPropertiesFile("AsertFailMessage"));
			log.info(readFile.readExcel(j, readPropertiesFile("ColumnName2"))
					+ " VHS Website successfully completed verification");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
