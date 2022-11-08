package PageObjects.Railway;

import Common.Constant.Constant;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class BasePage extends Constant {
//    private WebDriverWait wait;

    public void clickNarBar(String option){
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By optionNarBar = By.xpath("//span[text()='"+option+"']");
        driver.findElement(optionNarBar).click();
    }
    public void scrollToElement(){
        WebElement element = driver.findElement(By.id("footer"));
        Actions actions = new Actions(driver);
        actions.scrollToElement(element);
        actions.perform();
    }
    public void switchToNewWindow(){
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        driver.switchTo().window(winHandleBefore);
    }
    public void clickLinkText(String name){
        By link = By.linkText(name);
        driver.findElement(link).click();
    }

    public WebElement getBookedTicketInfor(String value){
        By valueInTable = By.xpath("//td[count(//table//th[.='"+value+"']/preceding-sibling::th)+1]");
        return (WebElement) valueInTable;
    }
    public void chooseDdlOption(WebElement element, String value){
        Select selectOption = new Select(element);
        selectOption.selectByVisibleText(value);
    }
    public void verifyDdlValues(WebElement element, String value){
        Select dropDown = new Select(element);
        List<WebElement> optionsValues = dropDown.getOptions();
        for (int i=0; i<optionsValues.size(); i++){
            Assert.assertEquals(value,dropDown.getFirstSelectedOption().getText());
        }
    }
}
