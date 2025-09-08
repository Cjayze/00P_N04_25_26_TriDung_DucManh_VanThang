public class TestUser {
    public static void run() {
        User user = new User("manh", "manh@example.com", "123456");
        user.displayInfo();
        user.setEmail("newmail@example.com");
        user.displayInfo();
    }
}