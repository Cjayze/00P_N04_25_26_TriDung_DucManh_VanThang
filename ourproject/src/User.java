package src;

public class User {
    private String name;
    private String email;

    // Constructor khởi tạo
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // Getter & Setter
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    // Giải phóng (finalize)
    @Override
    protected void finalize() throws Throwable {
        System.out.println("User object is being destroyed: " + name);
    }
}
