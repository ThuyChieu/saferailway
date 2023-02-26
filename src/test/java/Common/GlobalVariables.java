package Common;

import Executables.DriverSetup;
import Utilities.DataFaker;
import Utilities.PropertiesFile;

public class GlobalVariables extends DriverSetup {
    public static final String email = PropertiesFile.getPropValue("email");
    public static final String password = PropertiesFile.getPropValue("password");
    public static final String autoGenerateEmail = DataFaker.generateRandomEmail("");
    public static final String autoGeneratePassword = DataFaker.generateRandomStringWithSpecialChars(10);
    public static final String autoGeneratePID = DataFaker.generateRandomString(10);
    public static final String loginURL = "http://www.railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
}
