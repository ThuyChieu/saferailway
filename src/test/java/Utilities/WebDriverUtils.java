package Utilities;

import Utilities.Utility;

public class WebDriverUtils extends Utility {
    public static void maximizeWindow(){
        try{
            Utility.getDriver().manage().window().maximize();
        } catch (Exception e){
            Utility.log4j.error("maximizeWindow method - ERROR: ", e);
        }
    }
}
