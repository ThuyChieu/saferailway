package TestCases.login;

import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Common.GlobalVariables;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.GlobalVariables.RAILWAY_URL;


public class TC03_Unable_login_with_blank_Username extends BaseTest {
    private LoginPage loginPage;

    @Test(description = "User can't login with blank 'Username' textbox")
    public void TC_LOGIN_03() {
        try {
            loginPage = new LoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox");
            loginPage.login("", GlobalVariables.password);

            String blankUsernameMsg = loginPage.errorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message 'There was a problem with your login and/or errors exist in your form.' is displayed.");
            Assert.assertEquals(blankUsernameMsg, "There was a problem with your login and/or errors exist in your form.");
        }
        catch (Exception e){
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
