package PageObjects.Railway;

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
    }

    public void clickBtnRegister() {
        getBtnRegister.click();
    }
}
