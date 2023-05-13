package TestCases.bookTicket;

import Common.CommonMethods;
import Common.GlobalVariables;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC01_Able_book_ticket_with_valid_data extends BaseTest {
    private BookTicketPage bookTicketPage;
    private LoginPage loginPage;

    @Test(dataProvider = "getDataForTest", description = "User can book ticket with valid data")
    public void TC01_BT(Hashtable<String, String> data) {
        try {
            String departDate = CommonMethods.getSomeDaysAfter(5);
            String departStation = data.get("DepartStation");
            String arriveStation = data.get("ArriveStation");
            String seatType = data.get("SeatType");
            String ticketAmount = data.get("TicketAmount");

            loginPage = new LoginPage();
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
            bookTicketPage.chooseDdlOption(departDate,departStation,arriveStation,seatType,ticketAmount);

            logStep = TestReporter.logStepInfo(logMethod, "Step #6: Verify all options in drop down list are displayed correctly");
            bookTicketPage.verifyDdl(departDate,departStation,arriveStation,seatType,ticketAmount);

            logStep = TestReporter.logStepInfo(logMethod, "Step #7: Click book ticket button");
            bookTicketPage.clickBookTicketBtn();

            String successBookedTicketMsg = bookTicketPage.msgBookingSuccess();
            logStep = TestReporter.logStepInfo(logMethod, "Step #8: Success message is displayed");
            Assert.assertEquals(successBookedTicketMsg, data.get("SuccessMessage"));
        }
        catch (Exception e){
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
