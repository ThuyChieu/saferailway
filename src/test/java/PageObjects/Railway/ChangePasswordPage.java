package PageObjects.Railway;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends BasePage {
    @FindBy(id = "currentPassword")
    private WebElement getTxtCurrentPassword;
    @FindBy(id = "newPassword")
    private WebElement getGetTxtCurrentPassword;
    @FindBy(id = "confirmPassword")
    private WebElement getGetTxtConfirmPassword;
    public ChangePasswordPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }
    public void navigateChangePasswordPage() {
        clickNarBar("Change password");
    }

}
