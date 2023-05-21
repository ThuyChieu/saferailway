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

public class TC11_Unable_register_with_email_field_includes_more_than_2_emails extends BaseTest {
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "Unable to register new account with email field includes more than 2 emails")
    public void TC11_REGISTER(Hashtable<String, String> data) {
        try {
            registerPage = new RegisterPage();

            String email = GlobalVariables.autoGenerateEmail + GlobalVariables.autoGenerateEmail;

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Register with email field includes more than 2 emails");
            registerPage.register(email, GlobalVariables.password, GlobalVariables.password, GlobalVariables.autoGeneratePID);

            String errorMsg = registerPage.errorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message 'There're errors in the form. Please correct the errors and try again.' is displayed above the form.");
            Assert.assertEquals(errorMsg, data.get("RegisterErrMessage"));

        } catch (Exception e) {
            log4j.error("register method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify register method page - ERROR", e);
        }
    }

}
