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

public class TC06_Unable_login_with_wrong_password extends BaseTest {
    private LoginPage loginPage;

    @Test(dataProvider = "getDataForTest", description = "User can't login by providing wrong password")
    public void TC06_LOGIN(Hashtable<String, String> data) {
        try {
            loginPage = new LoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Input wrong password");
            loginPage.login(GlobalVariables.email, GlobalVariables.autoGeneratePassword);

            String errorMsg = loginPage.errorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Error message is displayed.");
            Assert.assertEquals(errorMsg, data.get("LoginErrMessage"));
        }
        catch (Exception e){
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
