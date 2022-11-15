package Common;

import Executables.DriverSetup;

public class Constant extends DriverSetup {
    public static final String email = PropertiesFile.getPropValue("email");
    public static final String password = PropertiesFile.getPropValue("password");
    public static final String autoGenerateEmail = Utilities.generateRandomEmail(10);
    public static final String autoGeneratePassword = Utilities.generateRandomStringWithSpecialChars(10);
    public static final String autoGeneratePID = Utilities.generateRandomString(10);
    public static final String loginURL = "http://www.railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";
}
