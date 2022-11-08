package PageObjects.Railway;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookTicketPage extends BasePage {
    @FindBy(xpath ="//select[@name='Date']")
    private WebElement getDdlDepartDate;
    @FindBy(xpath ="//select[@name='DepartStation']")
    private WebElement getDdlDepartStation;
    @FindBy(xpath ="//select[@name='ArriveStation']")
    private WebElement getDdlArriveStation;
    @FindBy(xpath ="//select[@name='SeatType']")
    private WebElement getDdlSeatType;
    @FindBy(xpath ="//select[@name='TicketAmount']")
    private WebElement getDdlTicketAmount;
    @FindBy(xpath ="//input[@value='Book ticket']")
    private WebElement getBtnBookTicket;

    public BookTicketPage(WebDriver webDriver){
        this.driver = webDriver;
        PageFactory.initElements(driver, this);
    }
    public void navigateBookTicketPage(){
        clickNarBar("Book ticket");
    }
    public void chooseDdl(){
        chooseDdlOption(getDdlDepartDate,"11/12/2022");
        chooseDdlOption(getDdlDepartStation,"Sài Gòn");
        chooseDdlOption(getDdlArriveStation,"Huế");
        chooseDdlOption(getDdlSeatType,"Soft bed with air conditioner");
        chooseDdlOption(getDdlTicketAmount,"1");
    }
    public void verifyDdl(){
        verifyDdlValues(getDdlDepartDate, "11/12/2022");
        verifyDdlValues(getDdlDepartStation, "Sài Gòn");
        verifyDdlValues(getDdlArriveStation, "Huế");
        verifyDdlValues(getDdlSeatType, "Soft bed with air conditioner");
        verifyDdlValues(getDdlTicketAmount, "1");
    }
    public void clickBtnBookTicket(){
        getBtnBookTicket.click();
    }
    public void verifyBookedTicket(){
        verifyDdlValues(getBookedTicketInfor("Depart Station"),"Sài Gòn");
        verifyDdlValues(getBookedTicketInfor("Arrive Station"),"Huế");
        verifyDdlValues(getBookedTicketInfor("Seat Type"),"Soft bed with air conditioner");
        verifyDdlValues(getBookedTicketInfor("Depart Date"),"11/12/2022");
        verifyDdlValues(getBookedTicketInfor("Amount"),"1");
    }
}
