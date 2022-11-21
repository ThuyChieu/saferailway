package PageObjects.Railway;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
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
    @FindBy(id = "footer")
    private WebElement getFooter;

    public LoginPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
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
        getBtnLogin.click();
        scrollToElement(getFooter);
    }

    public void login(String email, String password) {
        scrollToElement(getFooter);
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
        getBtnLogin.click();
    }

    public String verifyWelcome() {
        String text = getLblWelcome.getText();
        return text;
    }

    public String errorMsg() {
        String errorMsg = getLblError.getText();
        return errorMsg;
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

    public boolean verifyAdditionPagesDisplay(String tabName) {
        try {
            WebElement tab = navigationBar(tabName);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
