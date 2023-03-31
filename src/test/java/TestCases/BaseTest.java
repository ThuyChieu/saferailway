package TestCases;

import Utilities.PropertiesFile;
import Utilities.webDrivers.DriverSetup;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//public class BaseTest {
//    @BeforeMethod(alwaysRun = true)
//    public void run() {
//        PropertiesFile.setPropertiesFile();
//        String url = "http://www.raillog.somee.com/Page/HomePage.cshtml";
//        DriverSetup.createDriver(PropertiesFile.getPropValue("browser"));
//        DriverSetup.get(url);
//        DriverSetup.maximizeWindow();
//        DriverSetup.implicitWait();
//    }
//
//    @AfterMethod(alwaysRun = true)
//    public void closeDriver() {
//        try {
//            Thread.sleep(2000);
//            DriverSetup.quitDriver();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
