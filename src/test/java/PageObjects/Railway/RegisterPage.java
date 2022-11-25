package PageObjects.Railway;

import Common.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BasePage {
    @FindBy(id = "email")
    private WebElement getTxtEmail;
    @FindBy(id = "password")
    private WebElement getTxtPassword;
    @FindBy(id = "confirmPassword")
    private WebElement getTxtConfirmPassword;
    @FindBy(id = "pid")
    private WebElement getTxtPID;
    @FindBy(xpath = "//input[@value='Register']")
    private WebElement getBtnRegister;
    @FindBy(xpath = "//p[@class='message error']")
    private WebElement getLblError;
    @FindBy(xpath = "//label[@class='validation-error' and @for='password']")
    private WebElement getLblPassError;
    @FindBy(xpath = "//label[@class='validation-error' and @for='pid']")
    private WebElement getLblPIDError;

    public RegisterPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }
}
