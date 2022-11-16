package PageObjects.Railway;

import Common.PropertiesFile;
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
<<<<<<< HEAD

    @FindBy(xpath = "//p[@class='message error']")
    private WebElement getErrorMsg;

=======
>>>>>>> 028d1567fa0e9cbfbe0d38dedd4accee64aeb81d
    public ChangePasswordPage(WebDriver webdriver) {
        this.driver = webdriver;
        PageFactory.initElements(driver, this);
    }
    public void navigateChangePasswordPage() {
        clickNarBar("Change password");
    }
    public void inputInfor(String currentPass, String newPass, String confirmPass){
        getTxtCurrentPass.sendKeys(currentPass);
        getTxtNewPass.sendKeys(newPass);
<<<<<<< HEAD
=======
        PropertiesFile.setPropValue("password",newPass);
>>>>>>> 028d1567fa0e9cbfbe0d38dedd4accee64aeb81d
        getTxtConfirmPass.sendKeys(confirmPass);
    }
    public void clickBtnChangePass(){
        getBtnChangePass.click();
    }
<<<<<<< HEAD
    public String errorMsg(){
        String errorMsg = getErrorMsg.getText();
        return errorMsg;
    }
=======
>>>>>>> 028d1567fa0e9cbfbe0d38dedd4accee64aeb81d
}
