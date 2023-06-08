package TestCases.login;

import Common.GlobalVariables;
import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC05_Unable_login_with_blank_password extends BaseTest {
    private LoginPage loginPage;

    @Test(dataProvider = "getDataForTest", description = "User can't login with blank 'Password' textbox")
    public void TC05_LOGIN(Hashtable<String, String> data) {
        try {
            loginPage = new LoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: User doesn't type any words into 'Password' textbox but enter valid information into 'Password' textbox");
            loginPage.login(GlobalVariables.email, "");

            String errorMsg = loginPage.errorMsg();
            String passErrorMsg = loginPage.passwordErrorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message 'There was a problem with your login and/or errors exist in your form.' is displayed.");
            Assert.assertEquals(errorMsg, data.get("LoginErrMessage"));
            Assert.assertEquals(passErrorMsg, data.get("PassErrMessage"));
        }
        catch (Exception e){
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
