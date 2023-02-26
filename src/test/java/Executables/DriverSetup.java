package Executables;

import Utilities.TestReporter;
import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utilities.Utility;

import java.time.Duration;


public class DriverSetup {
    public static WebDriver driver;

    public WebDriver initializeDriver(String type) {
        Utility.log4j.info("createInstance method - Starts");
        switch (type.trim().toLowerCase()) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        maximizeWindow();
        impllicitWait();
        return driver;
    }

    public void findURL(String url) {
        driver.get(url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void impllicitWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}

