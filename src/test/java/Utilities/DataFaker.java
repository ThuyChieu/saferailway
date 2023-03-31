package Utilities;

import net.bytebuddy.utility.RandomString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import org.apache.log4j.BasicConfigurator;

public class DataFaker {
    public static String generateRandomString(int length) {
        return RandomString.make(length);
    }

    public static String generateRandomStringWithSpecialChars(int length) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk"
                + "lmnopqrstuvwxyz@";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    public static String generateRandomEmail(String email) {
        if (email.contains("@")) {
            String[] parts = email.split("@");
            return parts[0] + "+" + generateTimeStampString("HHmmssSSS") + "@" + parts[1];
        } else {
            throw new IllegalArgumentException("The string email doesn't contain @");
        }
    }

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return df.format(now);
    }
}
