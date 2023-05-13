package PageObjects.Railway;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTicketPage extends BasePage {

    @FindBy(id = "footer")
    private WebElement getFooter;
    @FindBy(xpath = "//div//input[@type='submit']")
    private WebElement button_ApplyFilter;


    private WebElement getBtnByRow(String rowNumber) {
        By btnCancel = By.xpath("//td[.='" + rowNumber + "']/..//input[@type='button' and @value='Cancel' or @value='Delete']");
        return Utility.getDriver().findElement(btnCancel);
    }

    public Boolean getBtnByID(String id) {
        try {
            By btnCancel = By.xpath("//input[@onclick='" + id + "']");
            Utility.getDriver().findElement(btnCancel);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public MyTicketPage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void navigateMyTicket() {
        navigationBar("My ticket").click();
    }

    public void clickCancelBtn(String row) {
        scrollToElement(getFooter);
        getBtnByRow(row).click();
    }

    public void clickOKAlert() {
        alertAccept();
        scrollToElement(getFooter);
    }

    public String getAtributeCanCelBtn(String rowNumber) {
        return getBtnByRow(rowNumber).getAttribute("onclick");
    }

    public boolean isFilterDisplayed(){
        return button_ApplyFilter.isDisplayed();
    }
}
