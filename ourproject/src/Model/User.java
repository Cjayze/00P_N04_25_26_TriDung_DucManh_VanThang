

public class User {
    protected int userId;
    protected String name;
    protected String email;
    protected String password;

    public User(int userId, String name, String email, String password) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public boolean register() {
        System.out.println("User registered: " + name);
        return true;
    }

    public boolean login(String email, String password) {
        return this.email.equals(email) && this.password.equals(password);
    }

    public void logout() {
        System.out.println(name + " logged out.");
    }
}
