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
        this.drivers = webdriver;
        PageFactory.initElements(drivers, this);
    }

    public void navigateChangePasswordPage() {
        navigationBar("Change password").click();
    }

    public void inputInfor(String currentPass, String newPass, String confirmPass) {
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
}
