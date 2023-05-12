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

public class TC12_Unable_create_account_with_empty_Email extends BaseTest {
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "User can't create account while email field is empty")
    public void TC12(Hashtable<String, String> data) {
        try {
            registerPage = new RegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Leaving email field empty");
            registerPage.register("", GlobalVariables.password, GlobalVariables.password, GlobalVariables.autoGeneratePID);

            String errorMsg = registerPage.errorMsg();
            String emailErrorMsg = registerPage.getEmailErrorMessage();
            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Message 'There're errors in the form. Please correct the errors and try again.' is displayed above the form.");
            Assert.assertEquals(errorMsg, data.get("ErrorMessage"));

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Error message 'You must specify a username.' is displayed");
            Assert.assertEquals(emailErrorMsg, data.get("EmailErrMessage"));
        } catch (Exception e) {
            log4j.error("register method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify register method page - ERROR", e);
        }
    }
}
