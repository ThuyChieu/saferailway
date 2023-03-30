package Executables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import Utilities.Utility;

import java.time.Duration;


public class DriverSetup {
    public static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void createDriver(String type) {
        Utility.log4j.info("createInstance method - Starts");
        switch (type.trim().toLowerCase()) {
            case "edge":
                WebDriverManager.edgedriver().setup();
                drivers.set(new EdgeDriver());
                break;
            case "chrome":
                WebDriverManager.chromedriver().setup();
                drivers.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                drivers.set(new FirefoxDriver());
                break;
        }
//        maximizeWindow();
//        implicitWait();
    }

    public static void get(String url) {
            drivers.get().get(url);
    }
    public static void quitDriver() {
            drivers.get().quit();
    }

    public static void maximizeWindow() {
        drivers.get().manage().window().maximize();
    }

    public static void implicitWait() {
        drivers.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }
}

