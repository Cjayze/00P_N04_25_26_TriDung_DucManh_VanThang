//package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static String getCurrentTime() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.now().format(fmt);
    }

    public static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) result *= i;
        return result;
    }
}
