package PageObjects.Railway;

import Utilities.PropertiesFile;
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
        this.drivers = webdriver;
        PageFactory.initElements(drivers, this);
    }

    public void navigateRegisterPage() {
        navigationBar("Register").click();
    }

    public void inputInformation(String email, String password, String PID) {
        scrollToElement(getTxtEmail);
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
        getTxtConfirmPassword.sendKeys(password);
        getTxtPID.sendKeys(PID);
        PropertiesFile.setPropValue("email", email);
        PropertiesFile.setPropValue("password", password);
    }

    public void register(String email, String password, String confirmPass, String PID) {
        scrollToElement(getTxtEmail);
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
        getTxtConfirmPassword.sendKeys(confirmPass);
        getTxtPID.sendKeys(PID);
        getBtnRegister.click();
    }

    public void clickBtnRegister() {
        getBtnRegister.click();
    }

    public String passErrorMsg() {
        String passErrorMsg = getLblPassError.getText();
        return passErrorMsg;
    }

    public String errorMsg() {
        String errorMsg = getLblError.getText();
        return errorMsg;
    }

    public String PIDErrorMsg() {
        String PIDErrorMsg = getLblPIDError.getText();
        return PIDErrorMsg;
    }
}
