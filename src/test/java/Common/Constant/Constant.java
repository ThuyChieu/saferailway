package Common.Constant;

import Executables.DriverSetup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;

public class Constant extends DriverSetup {

    @BeforeMethod
    public void run() {
        String url = "http://www.railwayb2.somee.com/Page/HomePage.cshtml";
        driver = openDriver("chrome");
        findURL(url);
    }
}
