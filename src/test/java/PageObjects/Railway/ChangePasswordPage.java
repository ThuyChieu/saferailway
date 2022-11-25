package PageObjects.Railway;

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

    public ChangePasswordPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }
}
