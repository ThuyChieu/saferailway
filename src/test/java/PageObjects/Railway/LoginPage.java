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
}
