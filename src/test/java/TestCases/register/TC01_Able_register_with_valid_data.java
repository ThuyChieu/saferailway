package TestCases.register;

import Common.GlobalVariables;
import PageObjects.Railway.RegisterPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC01_Able_register_with_valid_data extends BaseTest {
    private RegisterPage registerPage;

    @Test(description = "User can create new account")
    public void TC01_REGISTER() {
        try {
            registerPage = new RegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Enter valid information into all fields");
            registerPage.inputInformation(GlobalVariables.autoGenerateEmail, GlobalVariables.autoGeneratePassword,
                    GlobalVariables.autoGeneratePID);
            registerPage.clickBtnRegister();
        } catch (Exception e) {
            log4j.error("register method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify register method page - ERROR", e);
        }
    }
}
