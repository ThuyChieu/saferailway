package TestCases.login;

import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC09_Able_navigate_registration_link_text extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Test(description = "User can navigate to forgot password using forgot password link text")
    public void TC08_LOGIN() {
        try {
            loginPage = new LoginPage();
            registerPage = new RegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Navigate to Registration Page");
            loginPage.navigateRegisterPageLink();

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that Registration Page is displayed");
            Assert.assertTrue(registerPage.isRegisterPageTitleDisplayed(), "Registration Page is not displayed");
        } catch (Exception e) {
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }

}
