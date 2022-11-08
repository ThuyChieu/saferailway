package Common.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onFinish(ITestContext result) {

    }

    @Override
    public void onStart(ITestContext result) {
        System.out.println("========= INSTALLED CONFIGURATION DATA =========");
        System.out.println(" ");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("FAILED TESTCASE " + result.getName());

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("SKIPPED TESTCASE " + result.getName());

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("SUCCEED TESTCASE " + result.getName());
    }
}
