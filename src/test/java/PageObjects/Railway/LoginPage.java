package PageObjects.Railway;

import Utilities.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    @FindBy(xpath = "//h1[contains(text(),'Login Page')]")
    private WebElement getLoginPage;
    @FindBy(xpath = "//legend[contains(text(),'Password Reset Instructions Form')]")
    private WebElement getForgotPasswordPage;
    @FindBy(id = "username")
    private WebElement getTxtEmail;
    @FindBy(id = "password")
    private WebElement getTxtPassword;
    @FindBy(xpath = "//input[@type='submit']")
    private WebElement getBtnLogin;
    @FindBy(xpath = "//h1[@align='center']")
    private WebElement getLblWelcome;
    @FindBy(xpath = "//p[@class='message error LoginForm']")
    private WebElement getLblError;
    @FindBy(xpath = "//label[@class='validation-error']")
    private WebElement emailErrorMsg;
    @FindBy(xpath = "//label[@class='validation-error']")
    private WebElement passwordErrorMsg;

    @FindBy(id = "footer")
    private WebElement getFooter;

    public LoginPage() {
        PageFactory.initElements(Utility.getDriver(), this);
    }

    public void navigateLoginPage() {
        navigationBar("Login").click();
    }

    public void navigateRegisterPageLink() {
        clickLinkText("Registration Page");
    }

    public void navigateForgotPassLink() {
        clickLinkText("Forgot Password page");
    }

    public void inputInformation(String email, String password) {
        scrollToElement(getFooter);
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
    }

    public void clickBtnLogin() {
        scrollToElement(getFooter);
        getBtnLogin.click();
    }

    public void login(String email, String password) {
        scrollToElement(getFooter);
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
        getBtnLogin.click();
    }

    public String getLblWelcome() {
        String text = getLblWelcome.getText();
        return text;
    }

    public boolean isLoginPageTitleDisplayed() {
        return getLoginPage.isDisplayed();
    }

    public boolean isForgotPasswordPageTitleDisplayed() {
        return getForgotPasswordPage.isDisplayed();
    }
    public boolean isRegistrationPageTitleDisplayed() {
        return getForgotPasswordPage.isDisplayed();
    }

    public String errorMsg() {
        String errorMsg = getLblError.getText();
        return errorMsg;
    }

    public String emailErrorMsg() {
        String emailErrorMessage = emailErrorMsg.getText();
        return emailErrorMessage;
    }

    public String passwordErrorMsg() {
        String passErrorMsg = passwordErrorMsg.getText();
        return passErrorMsg;
    }

    public void loginMultipleTimesWithWrongPass(String email, String password) {
        for (int i = 0; i < 4; i++) {
            scrollToElement(getFooter);
            getTxtEmail.sendKeys(email);
            getTxtPassword.sendKeys(password);
            getBtnLogin.click();
            getTxtEmail.clear();
        }
    }

    public boolean displayAdditionPages(String tabName) {
        try {
            WebElement tab = navigationBar(tabName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
