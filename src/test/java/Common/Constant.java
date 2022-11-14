package Common;

import Executables.DriverSetup;
import org.testng.annotations.BeforeMethod;

public class Constant extends DriverSetup {
    public static final String email = PropertiesFile.getPropValue("email");
    public static final String password = PropertiesFile.getPropValue("password");
}
