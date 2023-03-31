package Common;

import Utilities.DataFaker;
import Utilities.PropertiesFile;

public class GlobalVariables {
    public static String BROWSER = PropertiesFile.getPropValue("browser");
    public static String PROJECT_PATH = System.getProperty("user.dir");
    public static String OUTPUT_PATH =  PROJECT_PATH + "/resources/output/";


    //data test
    public static final String email = PropertiesFile.getPropValue("email");
    public static final String password = PropertiesFile.getPropValue("password");
    public static final String autoGenerateEmail = DataFaker.generateRandomEmail("");
    public static final String autoGeneratePassword = DataFaker.generateRandomStringWithSpecialChars(10);
    public static final String autoGeneratePID = DataFaker.generateRandomString(10);
    public static final String loginURL = "http://www.railwayb2.somee.com/Account/Login.cshtml?ReturnUrl=/Page/BookTicketPage.cshtml";

    //report data
    public static int TOTAL_TESTCASES = 0;
    public static int TOTAL_EXECUTED = 0;
    public static int TOTAL_PASSED = 0;
    public static int TOTAL_FAILED = 0;
    public static int TOTAL_SKIPPED = 0;


}
