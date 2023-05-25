package TestCases.myTicket;

import Common.CommonMethods;
import Common.GlobalVariables;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import PageObjects.Railway.RegisterPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC02_Filter_only_appears_when_ticket_table_has_more_than_6_rows extends BaseTest {
    private MyTicketPage myTicketPage;
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;
    private RegisterPage registerPage;

    @Test(dataProvider = "getDataForTest", description = "User can book ticket with valid data")
    public void TC02_MT(Hashtable<String, String> data) throws Exception {
        String email = GlobalVariables.autoGenerateEmail;
        String password = GlobalVariables.autoGeneratePassword;
        registerPage = new RegisterPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
        WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Register Page");
        registerPage.navigateRegisterPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Enter valid information into all fields");
        registerPage.inputInformation(email, password, GlobalVariables.autoGeneratePID);
        registerPage.clickBtnRegister();

        int i;
        List<String> departStation = Arrays.asList(data.get("DepartStation").split("-"));
        List<String> arriveStation = Arrays.asList(data.get("ArriveStation").split("-"));
        List<String> seatType = Arrays.asList(data.get("SeatType").split("-"));
        String ticketAmount = data.get("TicketAmount");

        loginPage = new LoginPage();
        myTicketPage = new MyTicketPage();
        bookTicketPage = new BookTicketPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
        WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

        logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
        loginPage.navigateLoginPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login with valid account");
        loginPage.login(email, password);

        logStep = TestReporter.logStepInfo(logMethod, "Step #4: Navigate to Book Ticket Page");
        bookTicketPage.navigateBookTicketPage();

        logStep = TestReporter.logStepInfo(logMethod, "Step #5: Book ticket 5 times");
        for (i = 0; i < 5; i++) {
            bookTicketPage.navigateBookTicketPage();
            bookTicketPage.chooseDdlOption(CommonMethods.getSomeDaysAfter(i + 4), departStation.get(i), arriveStation.get(i), seatType.get(i), ticketAmount);
            WebDriverUtils.waitForPageLoaded();
            bookTicketPage.clickBookTicketBtn();
        }

        logStep = TestReporter.logStepInfo(logMethod, "Step #7: Navigate to My Ticket Page");
        myTicketPage.navigateMyTicket();

        logStep = TestReporter.logStepInfo(logMethod, "Step #8: Verify that filter is not displayed");
        Assert.assertFalse(myTicketPage.isFilterDisplayed(), "The filter is displayed");

        logStep = TestReporter.logStepInfo(logMethod, "Step #9: Book more 1 ticket");
        bookTicketPage.navigateBookTicketPage();
        bookTicketPage.chooseDdlOption(CommonMethods.getSomeDaysAfter(i + 4), departStation.get(i), arriveStation.get(i), seatType.get(i), ticketAmount);

        logStep = TestReporter.logStepInfo(logMethod, "Step #10: Book more Verify that filter is displayed");
        Assert.assertTrue(myTicketPage.isFilterDisplayed(), "The filter is not displayed");
    }

}
