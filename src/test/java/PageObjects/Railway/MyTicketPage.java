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
        return driver.findElement(btnCancel);
    }

    public MyTicketPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }
}
