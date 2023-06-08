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

    public static String generateRandomEmail() {

        String[] domains = { "gmail.com", "outlook.com" };
        Random random = new Random();

        String username = "user" + random.nextInt(1000); // Tạo một tên người dùng ngẫu nhiên
        String domain = domains[random.nextInt(domains.length)]; // Lấy ngẫu nhiên một tên miền từ danh sách

        String email = username + "@" + domain; // Ghép nối tên người dùng và tên miền để tạo địa chỉ email

        return email;
    }

    public static String generateTimeStampString(String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        LocalDateTime now = LocalDateTime.now();
        return df.format(now);
    }
}
