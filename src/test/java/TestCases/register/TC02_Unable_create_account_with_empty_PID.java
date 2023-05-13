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


public class TC02_Unable_create_account_with_empty_PID extends BaseTest {
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "User can't create account while password and PID fields are empty")
    public void TC02_REGISTER(Hashtable<String, String> data) {
        try {
            registerPage = new RegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Leaving PID field empty");
            registerPage.register(GlobalVariables.autoGeneratePassword, GlobalVariables.password, GlobalVariables.password, "");

            String errorMsg = registerPage.errorMsg();
            String PIDErrorMsg = registerPage.PIDErrorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Message 'There're errors in the form. Please correct the errors and try again.' is displayed above the form.");
            Assert.assertEquals(errorMsg, data.get("ErrorMessage"));

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Next to PID field, error message 'Invalid ID length' is displayed");
            Assert.assertEquals(PIDErrorMsg, data.get("PIDErrMessage"));
        } catch (Exception e) {
            log4j.error("register method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify register method page - ERROR", e);
        }
    }
}
