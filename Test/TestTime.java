import java.time.LocalDateTime;

public class TestTime {
    public static void run() {
        Time.displayCurrentTime();

        LocalDateTime start = LocalDateTime.now();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LocalDateTime end = LocalDateTime.now();

        long seconds = Time.calculateSeconds(start, end);
        System.out.println("Elapsed seconds: " + seconds);
    }
}
    