package PageObjects.Railway;

import Utilities.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimetablePage extends BasePage {

    @FindBy(name = "DepartStation")
    private WebElement getDdlDepartStation;

    @FindBy(name = "ArriveStation")
    private WebElement getDdlArriveStation;
    @FindBy(id = "footer")
    private WebElement getFooter;

    private WebElement btnBookTicket(String departStation, String arriveStation) {
        By btnBookTicket = By.xpath("//td[text()='" + departStation + "']/following-sibling::td[text()='" + arriveStation + "']/..//a[contains(@href, 'Book')]");
        return Utility.getDriver().findElement(btnBookTicket);
    }

    public TimetablePage(WebDriver webDriver) {
//        this.drivers = webDriver;
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void navigateTimetablePage() {
        navigationBar("Timetable").click();
    }

    public void clickBtnBookTicket(String departStation, String arriveStation) {
        scrollToElement(getFooter);
        btnBookTicket(departStation, arriveStation).click();
    }

    public void verifyDepartArrive(String departStation, String arriveStation) {
        scrollToElement(getFooter);
        verifyDdlValues(getDdlArriveStation, arriveStation);
        verifyDdlValues(getDdlDepartStation, departStation);
    }
}

