package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class MyTicketPage extends BasePage {

    @FindBy(id = "footer")
    private WebElement getFooter;
    @FindBy(xpath = "//select[@name='FilterDpStation']")
    private WebElement getDepartStation;
    @FindBy(xpath = "//select[@name='FilterStatus']")
    private WebElement getStatus;
    @FindBy(xpath = "//input[@value='Apply Filter']")
    private WebElement btnApplyFilter;

    @FindBy(xpath = "//table[@class ='MyTable']//tr[not (contains(@class, 'TableSmallHeader'))]")
    private WebElement rowTotalAfterFilter;

    @FindBy(xpath = "//div[@class='error message']")
    private WebElement lblErrorMsg;

    public WebElement filterDepartStationByRow(String departStation) {
        By depart = By.xpath("//td[count(//th[.='Depart Station']//preceding-sibling::th)+1][contains(text(),'" + departStation + "')]");
        return driver.findElement(depart);
    }

    public MyTicketPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public void navigateMyTicket() {
        navigationBar("My ticket").click();
    }

    public void chooseDdlOption(WebElement element, String value) {
        scrollToElement(getFooter);
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }

    public void filterDepart(String depart) {
        chooseDdlOption(getDepartStation, depart);
        btnApplyFilter.click();
        scrollToElement(getFooter);
    }

    public void filterStatus(String status) {
        chooseDdlOption(getStatus, status);
        btnApplyFilter.click();
        scrollToElement(getFooter);
    }

    public String errorMsg() {
        String errorMsg = lblErrorMsg.getText();
        return errorMsg;
    }

    public void verifyFilter(String depart) {
        verifyDdlValues(getDepartStation,(filterDepartStationByRow(depart)).getText());
//        Assert.assertEquals((filterDepartStationByRow(depart)).getText(), depart);
    }
}
