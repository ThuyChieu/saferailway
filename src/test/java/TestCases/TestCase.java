package TestCases;

import Common.CommonMethods;
import Common.GlobalVariables;
import PageObjects.Railway.*;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.GlobalVariables.RAILWAY_URL;

public class TestCase extends BaseTest {
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private ChangePasswordPage changePasswordPage;
    private MyTicketPage myTicketPage;

    private TimetablePage timetablePage;

    @Test(description = "User can log into Railway with valid username and password")
    public void TC01() {

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
        WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

//        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Register new account and go to login page");
//        CommonMethods.registerAndGoToLoginPage(logStep, GlobalVariables.autoGenerateEmail, GlobalVariables.autoGeneratePassword, GlobalVariables.autoGeneratePID);

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login with registered account");
        loginPage = new LoginPage();
        loginPage.login(GlobalVariables.email,GlobalVariables.password);
        loginPage.clickBtnLogin();

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Verify that login successfully");
        String text = loginPage.getLblWelcome();
        Assert.assertEquals(text, "Welcome to Safe Railway","Login unsuccessfully");

//
//    @Test(description = "Login page displays when un-logged User clicks on 'Book ticket' tab")
//    public void TC04() {
//        DataFaker.getLog();
//        Log.info("Navigate to QA Railway Website");
//        Log.info("Click on 'Book ticket' tab");
//        bookTicket = new BookTicketPage(drivers);
//        bookTicket.navigateBookTicketPage();
//
//        String URL = drivers.getCurrentUrl();
//        Log.info("Login page displays instead of Book ticket page");
//        Assert.assertEquals(URL, GlobalVariables.loginURL);
//    }
//
//    @Test(description = "System shows message when user enters wrong password several times")
//    public void TC05() {
//        DataFaker.getLog();
//        Log.info("Navigate to QA Railway Website");
//        login = new LoginPage(drivers);
//        Log.info("Click on 'Login' tab");
//        login.navigateLoginPage();
//        Log.info("Enter valid Email and invalid Password");
//        login.loginMultipleTimesWithWrongPass(GlobalVariables.email, GlobalVariables.autoGeneratePassword);
//
//        String errorMsg = login.errorMsg();
//        Log.info("Message 'You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.' appears.");
//        Assert.assertEquals(errorMsg, "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.");
//        Log.error("Error message is not displayed");
//    }
//
//    @Test(description = "Additional pages display once user logged in")
//    public void TC06() {
//        DataFaker.getLog();
//        Log.info("Navigate to QA Railway Website");
//        login = new LoginPage(drivers);
//        Log.info("Click on 'Login' tab");
//        login.navigateLoginPage();
//        Log.info("Login with valid account");
//        login.login(GlobalVariables.email, GlobalVariables.password);
//        login.displayAdditionPages("My ticket");
//        login.displayAdditionPages("Change password");
//        login.displayAdditionPages("Log out");
//    }
//
//
//
//    @Test(description = "User can change password")
//    public void TC09() {
//        DataFaker.getLog();
//        changePass = new ChangePasswordPage(drivers);
//        login = new LoginPage(drivers);
//        Log.info("Navigate to QA Railway Website");
//        Log.info("Click on 'Login' tab");
//        login.navigateLoginPage();
//        Log.info("Login with valid account");
//        login.login(GlobalVariables.email, GlobalVariables.password);
//        Log.info("Click on 'Change password' tab");
//        changePass.navigateChangePasswordPage();
//        Log.info("Enter valid value into all fields.");
//        String newPass = GlobalVariables.autoGeneratePassword;
//        changePass.inputInfor(GlobalVariables.password, newPass, newPass);
//        Log.info("Click on 'Change Password' button");
//        changePass.clickBtnChangePass();
//        PropertiesFile.setPropValue("password", newPass);
//    }
//
//
//    @Test(description = "User can't create account with 'Confirm password' is not the same with 'Password'")
//    public void TC10() {
//        DataFaker.getLog();
//        changePass = new ChangePasswordPage(drivers);
//        login = new LoginPage(drivers);
//        register = new RegisterPage(drivers);
//        Log.info("Navigate to QA Railway Website");
//        Log.info("Click on 'Register' tab");
//        register.navigateRegisterPage();
//        Log.info("Enter valid information into all fields except 'Confirm password' is not the same with 'Password'");
//        register.register(GlobalVariables.email, GlobalVariables.password, DataFaker.generateRandomStringWithSpecialChars(10), "123456789");
//
//        String errorMsg = changePass.errorMsg();
//        Log.info("Message 'There're errors in the form. Please correct the errors and try again.' is displayed");
//        Assert.assertEquals(errorMsg, "There're errors in the form. Please correct the errors and try again.");
//    }
//
//
//    @Test(description = "User can book 1 ticket at a time")
//    public void TC14() {
//        DataFaker.getLog();
//        Log.info("Navigate to QA Railway Website");
//        login = new LoginPage(drivers);
//        bookTicket = new BookTicketPage(drivers);
//        Log.info("Click on 'Login' tab");
//        login.navigateLoginPage();
//        Log.info("Login with valid Email and Password");
//        login.login(GlobalVariables.email, PropertiesFile.getPropValue("password"));
//        Log.info("Click on 'Book ticket' tab");
//        bookTicket.navigateBookTicketPage();
//        Log.info("Select a 'Depart date' from the list");
//        Log.info("Select 'Sài Gòn' for 'Depart from' and 'Nha Trang' for 'Arrive at'.");
//        Log.info("Select 'Soft bed with air conditioner' for 'Seat type'");
//        Log.info("Select '1' for 'Ticket amount'");
//        bookTicket.chooseDdlOption("12/21/2022", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
//        bookTicket.verifyDdl("12/21/2022", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
//        bookTicket.clickBtnBookTicket();
//        Log.info("Click on 'Book ticket' button");
//        bookTicket.verifyBookedTicketValue("12/21/2022", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
//        Log.info("Verify ticket information display correctly");
//
//        String message = bookTicket.msgBookingSuccess();
//        Assert.assertEquals(message, "Ticket Booked Successfully!");
//        Log.info("Message 'Ticket booked successfully!' displays.");
//    }
//
//    @Test(description = "User can open 'Book ticket' page by clicking on 'Book ticket' link in 'Train timetable' page")
//    public void TC15() {
//        DataFaker.getLog();
//        Log.info("Navigate to QA Railway Website");
//        login = new LoginPage(drivers);
//        timetable = new TimetablePage(drivers);
//        login.navigateLoginPage();
//        Log.info("Login with valid Email and Password");
//        login.login(GlobalVariables.email, PropertiesFile.getPropValue("password"));
//        Log.info("Click on 'Timetable' button");
//        timetable.navigateTimetablePage();
//        Log.info("Click on 'book ticket' link of the route from 'Huế' to 'Sài Gòn'");
//        timetable.clickBtnBookTicket("Huế", "Sài Gòn");
//        Log.info("'Book ticket' page is loaded with correct  'Depart from' and 'Arrive at' values.");
//        timetable.verifyDepartArrive("Huế", "Sài Gòn");
//    }
//
//    @Test(description = "User can cancel a ticket")
//    public void TC16() {
//        DataFaker.getLog();
//        Log.info("Navigate to QA Railway Website");
//        login = new LoginPage(drivers);
//        bookTicket = new BookTicketPage(drivers);
//        myTicket = new MyTicketPage(drivers);
//        Log.info("Click on 'Login' tab");
//        login.navigateLoginPage();
//        Log.info("Login with valid Email and Password");
//        login.login(GlobalVariables.email, PropertiesFile.getPropValue("password"));
//        Log.info("Click on 'Book ticket' tab");
//        bookTicket.navigateBookTicketPage();
//        Log.info("Select a 'Depart date' from the list");
//        Log.info("Select 'Sài Gòn' for 'Depart from' and 'Nha Trang' for 'Arrive at'.");
//        Log.info("Select 'Soft bed with air conditioner' for 'Seat type'");
//        Log.info("Select '1' for 'Ticket amount'");
//        bookTicket.bookTicket("12/21/2022", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
//        myTicket.navigateMyTicket();
//        String cancelID = myTicket.getAtributeCanCelBtn("2");
//        myTicket.clickCancelBtn("2");
//        myTicket.clickOKAlert();
//        Boolean result = myTicket.getBtnByID(cancelID);
//        Assert.assertTrue(result, "Delete failed");
//    }
//
//
//    @Test(description = "User can access to Registration Page link text")
//    public void testCaseRegistrationPageLink() {
//        login = new LoginPage(drivers);
//        login.navigateLoginPage();
//        login.navigateRegisterPageLink();
//    }
//
//    @Test(description = "User can access to Forgot Password Page link text")
//    public void testCaseForgotPassPageLink() {
//        login = new LoginPage(drivers);
//        login.navigateLoginPage();
//        login.navigateForgotPassLink();
//    }
    }
}
