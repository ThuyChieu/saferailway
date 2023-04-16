package Common;

import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import Utilities.TestReporter;
import Utilities.Utility;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.support.PageFactory;

import static Utilities.Utility.log4j;


public class CommonMethods {
    public static void registerAndGoToLoginPage(ExtentTest logStep, String emailAddress, String password, String PID) {
        try {
            log4j.info("registerAndGoToLoginPage - Starts");
            TestReporter.logInfo(logStep, "registerAndGoToLoginPage ...");

            RegisterPage registerPage = PageFactory.initElements(Utility.getDriver(), RegisterPage.class);
            registerPage.navigateRegisterPage();
            registerPage.inputInformation(emailAddress, password, PID);
            registerPage.clickBtnRegister();

            LoginPage loginPage = PageFactory.initElements(Utility.getDriver(), LoginPage.class);
            loginPage.navigateLoginPage();
            log4j.info("registerAndGoToLoginPage method - Ends");
        } catch (Exception e) {
            log4j.error("registerAndGoToLoginPage method - ERROR: ", e);
            TestReporter.logException(logStep, "registerAndGoToLoginPage - ERROR", e);
        }
    }


}
