package PageObjects.Railway;

import Common.Constant;
import net.bytebuddy.utility.RandomString;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Random;

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

    public WebElement getBookedTicketInfor(String value) {
        By valueInTable = By.xpath("//td[count(//table//th[.='" + value + "']/preceding-sibling::th)+1]");
        return (WebElement) valueInTable;
    }

    public void chooseDdlOption(WebElement element, String value) {
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }

    public void verifyDdlValues(WebElement element, String value) {
        Select dropDown = new Select(element);
        Assert.assertEquals(value, dropDown.getFirstSelectedOption().getText());
    }

    public static String generateRandomString(int length) {
        return RandomString.make(length);
    }

    public static String generateRandomStringWithSpecialChars(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomEmail(int length) {
        String domain = "@m.o";
        return generateRandomString(length - domain.length()) + domain;
    }
}
