package TestCases;

import Common.PropertiesFile;
import Executables.DriverSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest extends DriverSetup {
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void run() {
        PropertiesFile.setPropertiesFile();
        String url = "http://www.raillog.somee.com/Page/HomePage.cshtml";
        driver = openDriver(PropertiesFile.getPropValue("browser"));
        findURL(url);
        maximizeWindow();
        impllicitWait();
    }

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        try {
            Thread.sleep(2000);
            driver.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
