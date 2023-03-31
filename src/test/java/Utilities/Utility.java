package Utilities;

import Utilities.webDrivers.DriverSetup;
import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static Common.GlobalVariables.*;

public class Utility {
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public static String timeStampString = DataFaker.generateTimeStampString("yyyy-MM-dd-HH-mm-ss");
    public static String reportLocation = OUTPUT_PATH + "report-" + timeStampString + "/";


    public static Log log4j;

    public static String getStackTrace(StackTraceElement[] stackTraceElements) {
        try {
            String stackTrade = "";
            for (StackTraceElement e : stackTraceElements) {
                stackTrade += e.toString() + "</br>";
                //Get stacktrade from com.common.modules level only
                if (e.toString().startsWith("com.common.modules")) {
                    break;
                }
            }
            return stackTrade;
        } catch (Exception e) {
            return "";
        }
    }

    public static void log4jConfiguration() {
        try {
            log4j = LogFactory.getLog(new Object().getClass().getName());
        } catch (Exception e) {
            log4j.error("log4jConfiguaration method - ERROR: ", e);
        }
    }

    public static void setDriver(WebDriver webDriver) {
        driver.set(webDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quit(ExtentTest logTest) {
        try {
            Utility.getDriver().quit();
            TestReporter.logInfo(logTest, "Closed browser");
        } catch (Exception e) {
            log4j.error("Unable to close browser: ", e);
        }
    }

    public static void initializeDriver(ExtentTest logTest) {
//        PropertiesFile.setPropertiesFile();
//        String url = "http://www.raillog.somee.com/Page/HomePage.cshtml";
//        DriverSetup.createDriver(PropertiesFile.getPropValue("browser"));
//        DriverSetup.get(url);
//        DriverSetup.maximizeWindow();
//        DriverSetup.implicitWait();
        try {
            Utility.setDriver(DriverSetup.initializeDriver(logTest, BROWSER));
            Utility.getDriver().manage().deleteAllCookies();
            Utility.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } catch (Exception e) {
            TOTAL_FAILED++;
            log4j.error("initializeDriver method - ERROR: ", e);
            TestReporter.logException(logTest, "initializeDriver method - ERROR: ", e);
        }
    }

}

