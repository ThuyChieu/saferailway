package TestCases.register;

import Common.GlobalVariables;
import PageObjects.Railway.RegisterPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC10_Unable_create_account_with_PID_less_than_8_or_more_than_20 extends BaseTest {
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "Unable to register new account by using email length less than 6 or more than 32")
    public void TC10_REGISTER(Hashtable<String, String> data) {
        try {
            registerPage = new RegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Register with registered account");
            registerPage.register(GlobalVariables.autoGenerateEmail, GlobalVariables.password, GlobalVariables.password,data.get("PID"));

            String errorMsg = registerPage.errorMsg();
            String PIDErrorMsg = registerPage.PIDErrorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message 'There're errors in the form. Please correct the errors and try again.' is displayed above the form.");
            Assert.assertEquals(errorMsg, data.get("RegisterErrMessage"));

            logStep = TestReporter.logStepInfo(logMethod, "Step #5: Error PID message is displayed");
            Assert.assertEquals(PIDErrorMsg, data.get("PIDErrMessage"));
        } catch (Exception e) {
            log4j.error("register method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify register method page - ERROR", e);
        }
    }
}
