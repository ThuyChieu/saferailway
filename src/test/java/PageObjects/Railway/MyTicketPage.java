package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTicketPage extends BasePage {

    @FindBy(id = "footer")
    private WebElement getFooter;

    private WebElement getBtnByRow(String rowNumber) {
        By btnCancel = By.xpath("//td[.='" + rowNumber + "']/..//input[@type='button' and @value='Cancel' or @value='Delete']");
        return drivers.findElement(btnCancel);
    }

    public Boolean getBtnByID(String id) {
        try {
            By btnCancel = By.xpath("//input[@onclick='" + id + "']");
            drivers.findElement(btnCancel);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    public MyTicketPage(WebDriver webdriver) {
        this.drivers = webdriver;
        PageFactory.initElements(drivers, this);
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
}
