package PageObjects.Railway;

import Common.Constant;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BasePage extends Constant {

    public void clickNarBar(String option) {
        By optionNarBar = By.xpath("//span[text()='" + option + "']");
        driver.findElement(optionNarBar).click();
    }

    public void scrollToElement() {
        WebElement element = driver.findElement(By.id("footer"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(element);
        actions.perform();
    }

    public void switchToNewWindow() {
        String winHandleBefore = driver.getWindowHandle();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().window(winHandleBefore);
    }

    public void clickLinkText(String name) {
        By link = By.linkText(name);
        driver.findElement(link).click();
    }
}
