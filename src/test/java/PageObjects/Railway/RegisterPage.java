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
    private WebElement getErrorMsg;
    @FindBy(xpath = "//label[@class='validation-error' and @for='password']")
    private WebElement getPassErrorMsg;
    @FindBy(xpath = "//label[@class='validation-error' and @for='pid']")
    private WebElement getPIDErrorMsg;
    public RegisterPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }
    public void navigateRegisterPage() {
        clickNarBar("Register");
    }

    public void inputInformation(String email, String password, String PID) {
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
        getTxtConfirmPassword.sendKeys(password);
        getTxtPID.sendKeys(PID);
        PropertiesFile.setPropValue("email",email);
        PropertiesFile.setPropValue("password",password);
    }

    public void clickBtnRegister() {
        getBtnRegister.click();
    }
    public String passErrorMsg(){
        String passErrorMsg = getPassErrorMsg.getText();
        return passErrorMsg;
    }
    public String errorMsg(){
        String errorMsg = getErrorMsg.getText();
        return errorMsg;
    }
    public String PIDErrorMsg(){
        String PIDErrorMsg = getPIDErrorMsg.getText();
        return PIDErrorMsg;
    }
}
