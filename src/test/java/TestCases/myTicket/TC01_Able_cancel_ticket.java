package TestCases.myTicket;

import Common.CommonMethods;
import Common.GlobalVariables;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import PageObjects.Railway.MyTicketPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC01_Able_cancel_ticket extends BaseTest {
    private MyTicketPage myTicketPage;
    private LoginPage loginPage;
    private BookTicketPage bookTicketPage;

    @Test(dataProvider = "getDataForTest", description = "User can book ticket with valid data")
    public void TC01_MT(Hashtable<String, String> data) {
        try {
            String departDate = CommonMethods.getSomeDaysAfter(5);
            String departStation = data.get("DepartStation");
            String arriveStation = data.get("ArriveStation");
            String seatType = data.get("SeatType");
            String ticketAmount = data.get("TicketAmount");

            loginPage = new LoginPage();
            myTicketPage = new MyTicketPage();
            bookTicketPage = new BookTicketPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Login Page");
            loginPage.navigateLoginPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login with valid account");
            loginPage.login(GlobalVariables.email, GlobalVariables.password);

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Navigate to Book Ticket Page");
            bookTicketPage.navigateBookTicketPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #5: Book ticket with valid data");
            bookTicketPage.chooseDdlOption(departDate, departStation, arriveStation, seatType, ticketAmount);

            logStep = TestReporter.logStepInfo(logMethod, "Step #6: Click book ticket button");
            bookTicketPage.clickBookTicketBtn();

            logStep = TestReporter.logStepInfo(logMethod, "Step #7: Navigate to My Ticket Page");
            myTicketPage.navigateMyTicket();

            String cancelID = myTicketPage.getAtributeCanCelBtn("2");
            myTicketPage.clickCancelBtn("2");
            myTicketPage.clickOKAlert();
            Boolean result = myTicketPage.getBtnByID(cancelID);
            Assert.assertTrue(result, "Delete failed");
        } catch (Exception e) {
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
