package TestCases.login;

import Common.GlobalVariables;
import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC01_Able_login_with_valid_account extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01_LOGIN() {
        try {
            loginPage = new LoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login with valid account");
            loginPage.login(GlobalVariables.email, GlobalVariables.password);

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that login successfully");
            String text = loginPage.getLblWelcome();
            Assert.assertEquals(text, "Welcome to Safe Railway", "Login unsuccessfully");
        } catch (Exception e) {
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
