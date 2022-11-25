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
    protected void verifyDdlValues(WebElement element, String element2) {
        Select dropDown = new Select(element);
        Assert.assertEquals(dropDown.getFirstSelectedOption().getText(),element2);
    }

}
