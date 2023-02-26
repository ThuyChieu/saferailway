package Utilities;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Utility {
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
}
