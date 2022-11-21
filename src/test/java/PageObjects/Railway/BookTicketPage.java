package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BookTicketPage extends BasePage {
    @FindBy(name = "Date")
    private WebElement getDdlDepartDate;
    @FindBy(name = "DepartStation")
    private WebElement getDdlDepartStation;
    @FindBy(name = "ArriveStation")
    private WebElement getDdlArriveStation;
    @FindBy(name = "SeatType")
    private WebElement getDdlSeatType;
    @FindBy(name = "TicketAmount")
    private WebElement getDdlTicketAmount;
    @FindBy(xpath = "//input[@value='Book ticket']")
    private WebElement getBtnBookTicket;
    @FindBy(xpath = "//h1[@align='center']")
    private WebElement getLblBookSuccess;

    public WebElement getBookedTicketInfor(String value) {
        By valueInTable = By.xpath("//td[count(//table//th[.='" + value + "']/preceding-sibling::th)+1]");
        return (WebElement) valueInTable;
    }

    public BookTicketPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void navigateBookTicketPage() {
        navigationBar("Book ticket").click();
    }

    public void chooseDdlOption(WebElement element, String value) {
        scrollToElement(getDdlDepartDate);
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }

    public void verifyDdlValues(WebElement element, String value) {
        Select dropDown = new Select(element);
        Assert.assertEquals(value, dropDown.getFirstSelectedOption().getText());
    }

    public void chooseDdlOption() {
        chooseDdlOption(getDdlDepartDate, "11/23/2022");
        chooseDdlOption(getDdlDepartStation, "Sài Gòn");
        chooseDdlOption(getDdlArriveStation, "Nha Trang");
        chooseDdlOption(getDdlSeatType, "Soft bed with air conditioner");
        chooseDdlOption(getDdlTicketAmount, "1");
    }

    public void verifyDdl() {
        verifyDdlValues(getDdlDepartDate, "11/23/2022");
        verifyDdlValues(getDdlDepartStation, "Sài Gòn");
        verifyDdlValues(getDdlArriveStation, "Nha Trang");
        verifyDdlValues(getDdlSeatType, "Soft bed with air conditioner");
        verifyDdlValues(getDdlTicketAmount, "1");
    }

    public void clickBtnBookTicket() {
        getBtnBookTicket.click();
    }

    public void verifyBookedTicket() {
        verifyDdlValues(getBookedTicketInfor("Depart Station"), "Sài Gòn");
        verifyDdlValues(getBookedTicketInfor("Arrive Station"), "Huế");
        verifyDdlValues(getBookedTicketInfor("Seat Type"), "Soft bed with air conditioner");
        verifyDdlValues(getBookedTicketInfor("Depart Date"), "11/12/2022");
        verifyDdlValues(getBookedTicketInfor("Amount"), "1");
    }

    public String msgBookingSuccess() {
        String mess = getLblBookSuccess.getText();
        return mess;
    }
}
