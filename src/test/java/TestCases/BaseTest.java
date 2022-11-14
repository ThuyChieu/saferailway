package TestCases;

import Common.PropertiesFile;
import Executables.DriverSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//@Listeners({TestListener.class})
public class BaseTest extends DriverSetup {
    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void run() {
        PropertiesFile.setPropertiesFile();
        String url = "http://www.railwayb2.somee.com/Page/HomePage.cshtml";
        driver = openDriver(PropertiesFile.getPropValue("browser"));
        findURL(url);
    }
    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        try {
            Thread.sleep(5000);
            driver.close();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
