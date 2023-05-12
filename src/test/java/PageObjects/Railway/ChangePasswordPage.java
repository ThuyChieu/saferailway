package PageObjects.Railway;

import Utilities.PropertiesFile;
import Utilities.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage {
    @FindBy(id = "currentPassword")
    private WebElement getTxtCurrentPass;
    @FindBy(id = "newPassword")
    private WebElement getTxtNewPass;
    @FindBy(id = "confirmPassword")
    private WebElement getTxtConfirmPass;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement getBtnChangePass;

    @FindBy(xpath = "//p[@class='message error']")
    private WebElement getErrorLbl;
    @FindBy(xpath = "//label[@for='currentPassword'][@class='validation-error']")
    private WebElement currentPassErrorMessage;
    @FindBy(xpath = "//label[@for='newPassword'][@class='validation-error']")
    private WebElement newPassErrorMessage;
    @FindBy(xpath = "//label[@for='confirmPassword'][@class='validation-error']")
    private WebElement confirmPassErrorMessage;


    public ChangePasswordPage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void navigateChangePasswordPage() {
        navigationBar("Change password").click();
    }

    public void inputInfor(String currentPass, String newPass, String confirmPass) {
        scrollToElement(getTxtCurrentPass);
        getTxtCurrentPass.sendKeys(currentPass);
        getTxtNewPass.sendKeys(newPass);
        getTxtConfirmPass.sendKeys(confirmPass);
        PropertiesFile.setPropValue("password", newPass);
    }
    public void inputInforForChangePass(String currentPass, String newPass, String confirmPass) {
        scrollToElement(getTxtCurrentPass);
        getTxtCurrentPass.sendKeys(currentPass);
        getTxtNewPass.sendKeys(newPass);
        getTxtConfirmPass.sendKeys(confirmPass);
    }

    public void clickBtnChangePass() {
        getBtnChangePass.click();
        scrollToElement(getBtnChangePass);
    }

    public String errorMsg() {
        String errorMsg = getErrorLbl.getText();
        return errorMsg;
    }
    public String currentPassErrorMsg() {
        String currentPassError = currentPassErrorMessage.getText();
        return currentPassError;
    }
    public String newPassErrorMsg() {
        String newPassError = newPassErrorMessage.getText();
        return newPassError;
    }
    public String confirmPassErrorMsg() {
        String confirmPassError = confirmPassErrorMessage.getText();
        return confirmPassError;
    }
}
