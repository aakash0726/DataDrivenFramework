package tests;

import org.apache.logging.log4j.*;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import util.Base;

public class Listners extends Base implements ITestListener {
	
	private static Logger log = LogManager.getLogger(Listners.class.getName());

	public void onTestStart(ITestResult result) {
		log.info(result.getName()+ " : VERIFICATION STARTING");
	}

	public void onTestSuccess(ITestResult result) {
		log.info(result.getName()+ " : PASSED");
	}

	public void onTestFailure(ITestResult result) {
		takeScreenshot(result.getName());
		log.info(result.getName()+ " : FAILED");
	}

	public void onTestSkipped(ITestResult result) {
		log.info(result.getName()+ " : SKIPPED");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info(result.getName()+ " : TestFailedButWithinSuccessPercentage");
	}

	public void onStart(ITestContext context) {
		log.info(context.getName()+ " : Start ");
	}

	public void onFinish(ITestContext context) {
		log.info(context.getName()+ " : Finish ");
	}

	
}
