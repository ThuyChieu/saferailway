package Common;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {
        Log.info("TEST CASES DONE");
    }

    @Override
    public void onStart(ITestContext result) {
        Log.info("NEW TEST CASES STARTED");
        System.out.println(" ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        Log.info("FAILURE OF TEST CASES WITH PASSED PERCENTAGE"+ result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Log.error("FAILED TESTCASES " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Log.info("SKIPPED TESTCASES " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {

        Log.info("SUCCEED TESTCASES " + result.getName());
    }
}
