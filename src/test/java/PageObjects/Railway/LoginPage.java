package PageObjects.Railway;

import PageObjects.Railway.BasePage;
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
    @FindBy(xpath = "//div[@class='account']")
    private WebElement getEmailBanner;

    public LoginPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public void navigateLoginPage() {

        clickNarBar("Login");
    }
    public void navigateRegisterPageLink() {

        clickLinkText("Registration Page");
    }
    public void navigateForgotPassLink() {

        clickLinkText("Forgot Password page");
    }

    public void inputInformation(String email, String password) {
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
    }

    public void clickBtnLogin() {

        getBtnLogin.click();
    }
    public String verifyEmail(){
        String valueEmail = getEmailBanner.getText();
        return valueEmail;
    }
}
