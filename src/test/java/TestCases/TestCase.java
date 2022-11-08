package TestCases;

import Common.Listeners.TestListener;
import Common.Utilities.PropertiesFile;
import PageObjects.Railway.BasePage;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import org.openqa.selenium.support.ui.Select;

@Listeners(TestListener.class)
public class TestCase extends BasePage {
    private LoginPage login;
    private RegisterPage register;
    private BookTicketPage bookTicket;
    @Test()
    public void testCaseRegister() {
        register = new RegisterPage(driver);
        register.navigateRegisterPage();
        register.scrollToElement();
        register.inputInformation("chillchil@gmail.com", "123456789", "123456789");
        register.clickBtnRegister();
    }

    @Test(description = "User can login and book tickets successfully")
    public void testCaseLogin() {
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.inputInformation(PropertiesFile.getPropValue("email"),PropertiesFile.getPropValue("password"));
        login.clickBtnLogin();

        String email = login.verifyEmail();
        Assert.assertEquals(email,"Welcome chieu1@gmail.com");

        bookTicket = new BookTicketPage(driver);
        bookTicket.navigateBookTicketPage();
        bookTicket.scrollToElement();
        bookTicket.chooseDdl();
        bookTicket.verifyDdl();
        bookTicket.clickBtnBookTicket();
        bookTicket.scrollToElement();
//        bookTicket.verifyBookedTicket();

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
