package TestCases.changePassword;

import Common.GlobalVariables;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC16_Unable_change_password_with_empty_Current_password extends BaseTest {
    private ChangePasswordPage changePasswordPage;
    private LoginPage loginPage;

    @Test(dataProvider = "getDataForTest", description = "User can change password")
    public void TC16(Hashtable<String, String> data) {
        try {
            loginPage = new LoginPage();
            changePasswordPage = new ChangePasswordPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login with valid account");
            loginPage.login(GlobalVariables.email, GlobalVariables.password);

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Navigate to Change Password Page");
            changePasswordPage.navigateChangePasswordPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Input valid data to change password");
            changePasswordPage.inputInfor(data.get("CurrentPassword"), data.get("NewPassword"), data.get("ConfirmPassword"));
            changePasswordPage.clickBtnChangePass();

            String errorMsg = changePasswordPage.errorMsg();
            String currentPassMsg = changePasswordPage.currentPassErrorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Message fail to change password is displayed.");
            Assert.assertEquals(errorMsg, data.get("ErrorMessage"));
            Assert.assertEquals(currentPassMsg, data.get("CurrentPassErrorMessage"));
        }
        catch (Exception e){
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
