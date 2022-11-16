package TestCases;

import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.ChangePasswordPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Utilities;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import Common.Constant;

public class TestCase extends BaseTest {
    private LoginPage login;
    private RegisterPage register;
    private BookTicketPage bookTicket;
    private ChangePasswordPage changePass;

    private static final Logger Log = LogManager.getLogger(BaseTest.class);

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {
        Utilities.getLog();
        login = new LoginPage(driver);
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("Enter valid Email and Password");
        login.inputInformation(Constant.email, Constant.password);
        Log.info("Click on 'Login' button");
        login.clickBtnLogin();

        String email = login.verifyEmail();
        Log.info("Welcome + username is displayed");
        Assert.assertEquals(email, "Welcome chieu1@gmail.com");
    }

    @Test(description = "User can't login with blank 'Username' textbox")
    public void TC02() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("User doesn't type any words into 'Username' textbox but enter valid information into 'Password' textbox ");
        login.inputInformation("", Constant.password);
        Log.info("Click on 'Login' button");
        login.clickBtnLogin();

        String blankEmail = login.errorMsg();
        Log.info(" Message 'There was a problem with your login and/or errors exist in your form.' appears.");
        Assert.assertEquals(blankEmail, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test(description = "User cannot log into Railway with invalid password ")
    public void TC03() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("Enter valid Email and invalid Password");
        login.inputInformation(Constant.email, "");
        Log.info("Click on 'Login' button");
        login.clickBtnLogin();

        String errorMsg = login.errorMsg();
        Log.info(" Message 'There was a problem with your login and/or errors exist in your form.' appears.");
        Assert.assertEquals(errorMsg, "There was a problem with your login and/or errors exist in your form.");
    }

    @Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
    public void TC04() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on 'Book ticket' tab");
        bookTicket = new BookTicketPage(driver);
        bookTicket.navigateBookTicketPage();

        String URL = driver.getCurrentUrl();
        Log.info("Login page displays instead of Book ticket page");
        Assert.assertEquals(URL, Constant.loginURL);
    }

    @Test(description = "System shows message when user enters wrong password several times")
    public void TC05() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("Enter valid Email and invalid Password");
        login.loginMultipleTimesWithWrongPass(Constant.email, Constant.autoGeneratePassword);

        String errorMsg = login.errorMsg();
        Log.info("Message 'You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.' appears.");
        Assert.assertEquals(errorMsg, "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
        Log.error("Error message is not displayed");
    }

    @Test(description = "Additional pages display once user logged in")
    public void TC06() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("Enter valid Email and invalid Password");
        login.inputInformation(Constant.email, Constant.password);
        Log.info("Click on 'Login' button");
        login.clickBtnLogin();
    }

    @Test(description = "User can create new account")
    public void TC07() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        register = new RegisterPage(driver);
        Log.info("Click on 'Register' tab");
        register.navigateRegisterPage();
        register.scrollToElement();
        Log.info("Enter valid information into all fields");
        register.inputInformation(Constant.autoGenerateEmail, Constant.autoGeneratePassword, Constant.autoGeneratePID);
        Log.info("Click on 'Register' button");
        register.clickBtnRegister();
    }

    @Test(description = "User can change password")
    public void TC09() {
        Utilities.getLog();
        changePass = new ChangePasswordPage(driver);
        login = new LoginPage(driver);
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("Enter valid Email and Password");
        login.inputInformation(Constant.email, Constant.password);
        Log.info("Click on 'Login' button");
        login.clickBtnLogin();
        Log.info("Click on 'Change password' tab");
        changePass.navigateChangePasswordPage();
        Log.info("Enter valid value into all fields.");
        String newPass = Constant.autoGeneratePassword;
<<<<<<< HEAD
        changePass.inputInfor(Constant.password, newPass, newPass);
=======
        changePass.inputInfor(Constant.password,newPass,newPass);
>>>>>>> 028d1567fa0e9cbfbe0d38dedd4accee64aeb81d
        Log.info("Click on 'Change Password' button");
        changePass.clickBtnChangePass();
    }

<<<<<<< HEAD
    @Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
    public void TC10() {
        Utilities.getLog();
        changePass = new ChangePasswordPage(driver);
        login = new LoginPage(driver);
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        login.scrollToElement();
        Log.info("Enter valid Email and Password");
        login.inputInformation(Constant.email, Constant.password);
        Log.info("Click on 'Login' button");
        login.clickBtnLogin();
        Log.info("Click on 'Change password' tab");
        changePass.scrollToElement();
        changePass.navigateChangePasswordPage();
        Log.info("Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
        changePass.inputInfor(Constant.password,Constant.autoGeneratePassword, "123456789");
        Log.info("Click on 'Change Password' button");
        changePass.clickBtnChangePass();
        changePass.scrollToElement();

        String errorMsg = changePass.errorMsg();
        Log.info("Password change failed. Please correct the errors and try again.");
        Assert.assertEquals(errorMsg,"Password change failed. Please correct the errors and try again.");
    }

    @Test(description = "User can't create account while password and PID fields are empty")
    public void TC11() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        register = new RegisterPage(driver);
        Log.info("Click on 'Register' tab");
        register.navigateRegisterPage();
        register.scrollToElement();
        Log.info("Enter valid email address and leave other fields empty");
        register.inputInformation(Constant.autoGenerateEmail, "", "");
        Log.info("Click on 'Register' button");
        register.clickBtnRegister();
        register.scrollToElement();

        String errorMsg = register.errorMsg();
        String passErrorMsg = register.passErrorMsg();
        String PIDErrorMsg = register.PIDErrorMsg();
        Log.info("Message 'There're errors in the form. Please correct the errors and try again.' appears above the form.");
        Assert.assertEquals(errorMsg,"There're errors in the form. Please correct the errors and try again.");
        Log.info("Next to password fields, error message 'Invalid password length' displays");
        Assert.assertEquals(passErrorMsg,"Invalid password length");
        Log.info("Next to PID field, error message 'Invalid ID length' displays");
        Assert.assertEquals(PIDErrorMsg,"Invalid ID length");
    }


=======
>>>>>>> 028d1567fa0e9cbfbe0d38dedd4accee64aeb81d

    @Test(description = "User can book 1 ticket at a time")
    public void TC14() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        login = new LoginPage(driver);
        bookTicket = new BookTicketPage(driver);
        login.navigateLoginPage();
        Log.info("Click on 'Login' tab");
        login.scrollToElement();
        login.inputInformation(Constant.email, Constant.password);
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
