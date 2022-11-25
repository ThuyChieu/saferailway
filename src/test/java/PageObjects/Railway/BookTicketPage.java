package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(id = "footer")
    private WebElement getFooter;

    public BookTicketPage(WebDriver webDriver) {
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }

    public void navigateBookTicketPage() {
        navigationBar("Book ticket").click();
    }

    public void chooseDdlOption(WebElement element, String value) {
        scrollToElement(getFooter);
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }

    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        chooseDdlOption(getDdlDepartDate, departDate);
        chooseDdlOption(getDdlDepartStation, departStation);
        chooseDdlOption(getDdlArriveStation, arriveStation);
        chooseDdlOption(getDdlSeatType, seatType);
        chooseDdlOption(getDdlTicketAmount, ticketAmount);
        getBtnBookTicket.click();
    }
}

