package TestCases;

import Common.Log;
import Common.TestListener;
import Common.PropertiesFile;
import PageObjects.Railway.BasePage;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;

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
        register.inputInformation(BasePage.generateRandomEmail(8), generateRandomStringWithSpecialChars(8), generateRandomString(8));
        register.clickBtnRegister();
    }

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        login = new LoginPage(driver);
        Log.info("Navigate to QA Railway Website");
        login.navigateLoginPage();
        Log.info("Click on 'Login' tab");
        login.scrollToElement();
        login.inputInformation(PropertiesFile.getPropValue("email"), PropertiesFile.getPropValue("password"));
        Log.info("Enter valid Email and Password");
        login.clickBtnLogin();
        Log.info("Click on 'Login' button");

        String email = login.verifyEmail();
        Log.info("Welcome + username is displayed");
        Assert.assertEquals(email, "Welcome chieu1@gmail.com");
    }

    @Test(description = "User can't login with blank 'Username' textbox")
    public void TC02() {
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        login.navigateLoginPage();
        Log.info("Click on 'Login' tab");
        login.scrollToElement();
        login.inputInformation("", PropertiesFile.getPropValue("password"));
        Log.info("User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox ");
        login.clickBtnLogin();
        Log.info("Click on 'Login' button");

        String email = login.errorMsg();
        Log.info(" Message 'There was a problem with your login and/or errors exist in your form.' appears.");
        Assert.assertEquals(email, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test(description = "User cannot log into Railway with invalid password ")
    public void TC03() {
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.inputInformation(PropertiesFile.getPropValue("email"), "");
        login.clickBtnLogin();

        String email = login.errorMsg();
        Assert.assertEquals(email, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        bookTicket = new BookTicketPage(driver);
        login.navigateLoginPage();
        Log.info("Click on 'Login' tab");
        login.scrollToElement();
        login.inputInformation(PropertiesFile.getPropValue("email"), PropertiesFile.getPropValue("password"));
        Log.info("Enter valid Email and Password");
        login.clickBtnLogin();
        Log.info("Click on 'Login' button");
        bookTicket.navigateBookTicketPage();
        Log.info("Click on 'Book ticket' tab");
        bookTicket.scrollToElement();
        bookTicket.chooseDdlOption();
        Log.info("Select a 'Depart date' from the list");
        Log.info("Select 'Sài Gòn' for 'Depart from' and 'Nha Trang' for 'Arrive at'.");
        Log.info("Select 'Soft bed with air conditioner' for 'Seat type'");
        Log.info("Select '1' for 'Ticket amount'");
        bookTicket.verifyDdl();
        bookTicket.clickBtnBookTicket();
        Log.info("Click on 'Book ticket' button");
        bookTicket.scrollToElement();
        bookTicket.verifyBookedTicket();
        Log.info("Verify ticket information display correctly");

        String message = bookTicket.msgBookingSuccess();
        Assert.assertEquals(message, "Ticket Booked Successfully!");
        Log.info("Message 'Ticket booked successfully!' displays.");
    }

    @Test(description = "User can access to Registration Page link text")
    public void testCaseRegistrationPageLink() {
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.navigateRegisterPageLink();
    }

    @Test(description = "User can access to Forgot Password Page link text")
    public void testCaseForgotPassPageLink() {
        login = new LoginPage(driver);
        login.navigateLoginPage();
        login.scrollToElement();
        login.navigateForgotPassLink();
    }
}
