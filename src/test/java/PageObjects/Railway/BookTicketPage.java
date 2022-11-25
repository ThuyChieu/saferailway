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
}
