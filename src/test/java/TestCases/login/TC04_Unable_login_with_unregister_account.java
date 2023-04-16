package TestCases.login;

import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Utilities.DataFaker;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.GlobalVariables.RAILWAY_URL;


public class TC04_Unable_login_with_unregister_account extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "User can't login with an account hasn't been registered")
    public void TC04() {
        try {
            loginPage = new LoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login with unregister account");
            loginPage.login(DataFaker.generateRandomEmail(), DataFaker.generateRandomString(10));

            String errorMsg = loginPage.errorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message 'Invalid username or password. Please try again.' is displayed.");
            Assert.assertEquals(errorMsg, "Invalid username or password. Please try again.");
        } catch (Exception e) {
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
