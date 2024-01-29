package base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListnerExamples  implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("Test start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("Test Sucess");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log("Test Fail");
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("Test Skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("TestFailedButWithinSuccessPercentage");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("TestFailedWithTimeout");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("On Start");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("On Finish");
	}

}
