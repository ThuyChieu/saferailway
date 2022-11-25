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

    @FindBy(id = "footer")
    private WebElement getFooter;

    public LoginPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }

    public void navigateLoginPage() {
        navigationBar("Login").click();
    }

    public void login(String email, String password) {
        scrollToElement(getFooter);
        getTxtEmail.sendKeys(email);
        getTxtPassword.sendKeys(password);
        getBtnLogin.click();
    }
}

