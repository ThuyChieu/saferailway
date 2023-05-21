package PageObjects.Railway;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(),'Book ticket')]")
    private WebElement getBookTicketTitle;
    @FindBy(xpath = "//select[@name='Date']")
    private WebElement getDdlDepartDate;
    @FindBy(xpath = "//select[@name='DepartStation']")
    private WebElement getDdlDepartStation;
    @FindBy(xpath = "//select[@name='ArriveStation']")
    private WebElement getDdlArriveStation;
    @FindBy(xpath = "//select[@name='SeatType']")
    private WebElement getDdlSeatType;
    @FindBy(xpath = "//select[@name='TicketAmount']")
    private WebElement getDdlTicketAmount;
    @FindBy(xpath = "//input[@value='Book ticket']")
    private WebElement getBtnBookTicket;
    @FindBy(xpath = "//h1[@align='center']")
    private WebElement getLblBookSuccess;

    @FindBy(id = "footer")
    private WebElement getFooter;

    private WebElement getBookedTicketInfor(String value) {
        By valueInTable = By.xpath("//td[count(//table//th[.='" + value + "']/preceding-sibling::th)+1]");
        return Utility.getDriver().findElement(valueInTable);
    }

    public BookTicketPage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void navigateBookTicketPage() {
        navigationBar("Book ticket").click();
    }

    public boolean isBookTicketPageTitleDisplayed() {
        return getBookTicketTitle.isDisplayed();
    }

    public void chooseDdlOption(WebElement element, String value) {
        scrollToElement(getFooter);
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }

    public void chooseDdlOption(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        chooseDdlOption(getDdlDepartDate, departDate);
        chooseDdlOption(getDdlDepartStation, departStation);
        chooseDdlOption(getDdlArriveStation, arriveStation);
        chooseDdlOption(getDdlSeatType, seatType);
        chooseDdlOption(getDdlTicketAmount, ticketAmount);
    }

    public void verifyDdl(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        verifyDdlValues(getDdlDepartDate, departDate);
        verifyDdlValues(getDdlDepartStation, departStation);
        verifyDdlValues(getDdlArriveStation, arriveStation);
        verifyDdlValues(getDdlSeatType, seatType);
        verifyDdlValues(getDdlTicketAmount, ticketAmount);
    }

    public void clickBookTicketBtn() {
        getBtnBookTicket.click();
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        chooseDdlOption(getDdlDepartDate, departDate);
        chooseDdlOption(getDdlDepartStation, departStation);
        chooseDdlOption(getDdlArriveStation, arriveStation);
        chooseDdlOption(getDdlSeatType, seatType);
        chooseDdlOption(getDdlTicketAmount, ticketAmount);
        getBtnBookTicket.click();
    }

    public void verifyBookedTicketValue(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        scrollToElement(getFooter);
        verifyBookedTicket(getBookedTicketInfor("Depart Date"), departDate);
        verifyBookedTicket(getBookedTicketInfor("Depart Station"), departStation);
        verifyBookedTicket(getBookedTicketInfor("Arrive Station"), arriveStation);
        verifyBookedTicket(getBookedTicketInfor("Seat Type"), seatType);
        verifyBookedTicket(getBookedTicketInfor("Amount"), ticketAmount);
    }

    public String msgBookingSuccess() {
        String mess = getLblBookSuccess.getText();
        return mess;
    }
}
