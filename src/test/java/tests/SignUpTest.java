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

	@Test(priority = 2)
	public void verifyInvalidPasswordFormatMessage() {
		ReadExcelFile readFile = new ReadExcelFile();
		for (int j = 1; j < readFile.totalNumberOfRow(); j++) {
			driver.get(readFile.readExcel(j, readPropertiesFile("ColumnName")));
			Utility u = new Utility();
			u.signUpToVHSWithWrongPasswordFormat();
			assertTrue(u.validationMessageForWrongFormatPassword(),
					"Validation message is not showing for invalid password format on Password field as per specification");
			log.info("verify Invalid Password Format Message test completed for: "
					+ readFile.readExcel(j, readPropertiesFile("ColumnName2")) + " VHS Website");

		}
	}

	@Test(priority = 1)
	public void verifyNotSamePasswordValidationMessage() {
		ReadExcelFile readFile = new ReadExcelFile();
		for (int j = 1; j < readFile.totalNumberOfRow(); j++) {
			driver.get(readFile.readExcel(j, readPropertiesFile("ColumnName")));
			Utility u = new Utility();
			u.signUpToVHSWithNotSamePasswordFormat();
			assertTrue(u.validationMessageForNotSamePassword(),
					"Validation message is not showing for not same password on Repeat Password field  as per specification");
			log.info("verify not same password validation message test completed for: "
					+ readFile.readExcel(j, readPropertiesFile("ColumnName2")) + " VHS Website");
		}
	}

	@AfterTest
	public void closeBrowser() {
		driver.close();
	}
}
