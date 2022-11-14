package Common;

import net.bytebuddy.utility.RandomString;

import java.util.Random;
import org.apache.log4j.BasicConfigurator;

public class Utilities {
    public static String generateRandomString(int length) {
        return RandomString.make(length);
    }

    public static String generateRandomStringWithSpecialChars(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomEmail(int length) {
        String domain = "@m.o";
        return generateRandomString(length - domain.length()) + domain;
    }
    public static void getLog() {
        BasicConfigurator.configure();
    }
}
