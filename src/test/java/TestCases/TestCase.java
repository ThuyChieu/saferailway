package TestCases;

import PageObjects.Railway.BasePage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.annotations.Test;


public class TestCase extends BasePage {
    private LoginPage login;
    private RegisterPage register;
    @Test()
    public void testCaseRegister() {
        register = new RegisterPage(driver);
        register.navigateRegisterPage();
        register.scrollToElement();
        register.inputInformation("chillchil@gmail.com", "123456789", "123456789");
        register.clickBtnRegister();
    }

    @Test(description = "User can login successfully")
    public void testCaseLogin() {
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.inputInformation("chieu1@gmail.com", "123456789");
        login.clickBtnLogin();
    }
    @Test(description = "User can access to Registration Page link text")
    public void testCaseRegistrationPageLink(){
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.navigateRegisterPageLink();
    }
    @Test(description = "User can access to Forgot Password Page link text")
    public void testCaseForgotPassPageLink(){
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.navigateForgotPassLink();
    }
}
