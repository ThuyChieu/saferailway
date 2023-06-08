package TestCases.login;

import Common.CommonMethods;
import Common.GlobalVariables;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;
import static Common.GlobalVariables.password;

public class TC07_Password_is_case_sensitive extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "User can't login by providing wrong password")
    public void TC07_LOGIN(Hashtable<String, String> data) {
        try {
            loginPage = new LoginPage();
            registerPage = new RegisterPage();

            String upperCasePassword = data.get("PasswordUppercase");
            String lowerCasePassword = data.get("PasswordLowercase");
            String email = GlobalVariables.autoGenerateEmail;

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
            registerPage.navigateRegisterPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Enter valid information into all fields");
            registerPage.register(email, upperCasePassword, upperCasePassword, GlobalVariables.autoGeneratePID);

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #5: Input uppercase password");
            loginPage.login(email,lowerCasePassword);

            String errorMsg = loginPage.errorMsg();
            logStep = TestReporter.logStepInfo(logMethod, "Step #6: Error message is displayed.");
            Assert.assertEquals(errorMsg, data.get("LoginErrMessage"));
        }
        catch (Exception e){
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }

}
