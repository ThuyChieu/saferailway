package TestCases.bookTicket;

import Common.GlobalVariables;
import PageObjects.Railway.BookTicketPage;
import PageObjects.Railway.LoginPage;
import TestCases.BaseTest;
import Utilities.TestReporter;
import Utilities.WebDriverUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import static Common.GlobalVariables.RAILWAY_URL;

public class TC02_Unable_navigate_book_ticket_without_login extends BaseTest {
    private BookTicketPage bookTicketPage;
    private LoginPage loginPage;

    @Test(description = "Users are not able to navigate to book ticket page without login")
    public void TC02_BT() {
        try {
            loginPage = new LoginPage();
            bookTicketPage = new BookTicketPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #1: Navigate to Railway");
            WebDriverUtils.navigateToPage(logStep, RAILWAY_URL);

            logStep = TestReporter.logStepInfo(logMethod, "Step #2: Navigate to Book Ticket Page");
            bookTicketPage.navigateBookTicketPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #3: Login page is displayed");
            Assert.assertTrue(loginPage.isLoginPageTitleDisplayed(), "Login page is not displayed");

            logStep = TestReporter.logStepInfo(logMethod, "Step #4: Login with valid account");
            loginPage.login(GlobalVariables.email, GlobalVariables.password);

            logStep = TestReporter.logStepInfo(logMethod, "Step #5: Navigate to Book Ticket Page");
            bookTicketPage.navigateBookTicketPage();

            logStep = TestReporter.logStepInfo(logMethod, "Step #6: Book ticket page is displayed");
            Assert.assertTrue(bookTicketPage.isBookTicketPageTitleDisplayed(), "Book ticket page is not displayed");
        } catch (Exception e) {
            log4j.error("login method - ERROR: ", e);
            TestReporter.logException(logStep, "Verify login method page - ERROR", e);
        }
    }
}
