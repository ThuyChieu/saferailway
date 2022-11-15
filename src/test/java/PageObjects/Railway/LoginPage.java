package PageObjects.Railway;

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
    @FindBy(xpath = "//p[@class='message error LoginForm']")
    private WebElement getErrorMsg;

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
    public String errorMsg(){
        String errorMsg = getErrorMsg.getText();
        return errorMsg;
    }
    public void loginMultipleTimesWithWrongPass(String email, String password){
        for (int i = 0;i<4; i++){
            getTxtEmail.sendKeys(email);
            getTxtPassword.sendKeys(password);
            getBtnLogin.click();
            getTxtEmail.clear();
        }
    }
    public void verifyAdditionPagesDisplay(){

    }
}
