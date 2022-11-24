package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage extends Constant {

    protected WebElement navigationBar(String option) {
        By optionNarBar = By.xpath("//span[text()='" + option + "']");
        return driver.findElement(optionNarBar);
    }

    protected void scrollToElement(WebElement element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(element);
        actions.perform();
    }

    protected void alertAccept(){
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    protected void switchToNewWindow() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().window(winHandleBefore);
    }

    protected void clickLinkText(String name) {
        By link = By.linkText(name);
        driver.findElement(link).click();
    }
    protected void verifyDdlValues(WebElement element, String value) {
        Select dropDown = new Select(element);
        Assert.assertEquals(value, dropDown.getFirstSelectedOption().getText());
    }
    protected void verifyBookedTicket(WebElement element, String value) {
        Assert.assertEquals(value, element.getText());
    }
}
