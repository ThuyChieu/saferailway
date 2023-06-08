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

public class TC09_Unable_create_account_with_password_and_confirm_password_does_not_match extends BaseTest {
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "User can't create account while password field is empty")
    public void TC09_REGISTER(Hashtable<String, String> data) {
        try {
            registerPage = new RegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Fill password and corfirm password does not match");
            registerPage.register(GlobalVariables.autoGenerateEmail, GlobalVariables.autoGeneratePassword, data.get("ConfirmPassword"), GlobalVariables.autoGeneratePID);

            String errorMsg = registerPage.errorMsg();
            String confirmPassErrorMsg = registerPage.confirmPassErrorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message 'There're errors in the form. Please correct the errors and try again.' is displayed above the form.");
            Assert.assertEquals(errorMsg, data.get("RegisterErrMessage"));

            logStep = TestReporter.logStepInfo(logMethod, "Step #5: Error password message is displayed");
            Assert.assertEquals(confirmPassErrorMsg, data.get("ConfirmPasswordErrMessage"));
        } catch (Exception e) {
            log4j.error("register method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify register method page - ERROR", e);
        }
    }

}
