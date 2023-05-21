package PageObjects.Railway;

import Utilities.PropertiesFile;
import Utilities.Utility;
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
    @FindBy(xpath = "//h1[contains(text(),'Create account')]")
    private WebElement getRegisterPageTitle;
    @FindBy(xpath = "//p[@class='message error']")
    private WebElement getLblError;
    @FindBy(xpath = "//label[@class='validation-error']")
    private WebElement txt_EmailErrorMessage;
    @FindBy(xpath = "//label[@class='validation-error' and @for='password']")
    private WebElement getLblPassError;
    @FindBy(xpath = "//label[@class='validation-error' and @for='pid']")
    private WebElement getLblPIDError;
    @FindBy(xpath = "//label[@class='validation-error' and @for='confirmPassword']")
    private WebElement getConfirmPasswordError;


    public RegisterPage() {
        PageFactory.initElements(Utility.getDriver(), this);
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
    public boolean isRegisterPageTitleDisplayed() {
        return getRegisterPageTitle.isDisplayed();
    }

    public void clickBtnRegister() {
        getBtnRegister.click();
    }

    public String passErrorMsg() {
        String passErrorMsg = getLblPassError.getText();
        return passErrorMsg;
    }
    public String confirmPassErrorMsg() {
        String confirmPassErrorMsg = getConfirmPasswordError.getText();
        return confirmPassErrorMsg;
    }

    public String errorMsg() {
        String errorMsg = getLblError.getText();
        return errorMsg;
    }

    public String PIDErrorMsg() {
        String PIDErrorMsg = getLblPIDError.getText();
        return PIDErrorMsg;
    }

    public String getEmailErrorMessage () {
        return txt_EmailErrorMessage.getText();
    }
}
