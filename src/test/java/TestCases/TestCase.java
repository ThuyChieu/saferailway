package TestCases;

import Common.PropertiesFile;
import PageObjects.Railway.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import Common.Utilities;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import Common.Constant;

public class TestCase extends BaseTest {
    private LoginPage login;
    private BookTicketPage bookTicket;
    private RegisterPage register;
    private MyTicketPage myTicket;
    private static final Logger Log = LogManager.getLogger(BaseTest.class);

    @Test(description = "User can filter 'Manager ticket' table with Depart Station")
    public void TC01() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        bookTicket = new BookTicketPage(driver);
        myTicket = new MyTicketPage(driver);
        Log.info("Click on 'Register' tab");
        register.navigateRegisterPage();
        Log.info("Enter valid information into all fields");
        register.inputInformation(Constant.autoGenerateEmail, Constant.autoGeneratePassword, Constant.autoGeneratePID);
        Log.info("Click on 'Register' button");
        register.clickBtnRegister();
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        Log.info("Login with valid Email and Password");
        login.login(PropertiesFile.getPropValue("email"), PropertiesFile.getPropValue("password"));
        Log.info("Click on 'Book ticket' tab");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Nha Trang", "Phan Thiết", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Huế", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Quảng Ngãi", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Đà Nẵng", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Phan Thiết", "Nha Trang", "Soft bed with air conditioner", "1");
        myTicket.navigateMyTicket();
        myTicket.filterDepart("Sài Gòn");
        myTicket.verifyFilter("Sài Gòn");
    }

    @Test(description = "Error displays when user applies filter with un-existed value of 'Status' in 'Manage ticket' table")
    public void TC02() {
        Utilities.getLog();
        Log.info("Navigate to QA Railway Website");
        register = new RegisterPage(driver);
        login = new LoginPage(driver);
        bookTicket = new BookTicketPage(driver);
        myTicket = new MyTicketPage(driver);
        Log.info("Click on 'Register' tab");
        register.navigateRegisterPage();
        Log.info("Enter valid information into all fields");
        register.inputInformation(Constant.autoGenerateEmail, Constant.autoGeneratePassword, Constant.autoGeneratePID);
        Log.info("Click on 'Register' button");
        register.clickBtnRegister();
        Log.info("Navigate to QA Railway Website");
        Log.info("Click on 'Login' tab");
        login.navigateLoginPage();
        Log.info("Login with valid Email and Password");
        login.login(PropertiesFile.getPropValue("email"), PropertiesFile.getPropValue("password"));
        Log.info("Click on 'Book ticket' tab");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Sài Gòn", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Nha Trang", "Phan Thiết", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Huế", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Quảng Ngãi", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Đà Nẵng", "Nha Trang", "Soft bed with air conditioner", "1");
        bookTicket.navigateBookTicketPage();
        bookTicket.bookTicket("12/21/2022", "Phan Thiết", "Nha Trang", "Soft bed with air conditioner", "1");
        myTicket.navigateMyTicket();
        myTicket.filterStatus("Paid");

        String message = myTicket.errorMsg();
        Assert.assertEquals(message, "Sorry, can't find any results that match your filters.\n" +
                "Please change the filters and try again.");
    }
}

