package com.example.demo.dao;

import com.example.demo.model.User;
import java.util.*;

public class UserDAO {
    private final List<User> users = new ArrayList<>();

    public UserDAO() {
        users.add(new User("Tri Dung","tridung@example.com"));
        users.add(new User("Duc Manh","ducmanh@example.com"));
    }

    public List<User> getAll() { return users; }
    public User getByEmail(String email) { return users.stream().filter(u->u.getEmail().equals(email)).findFirst().orElse(null); }
    public void add(User u) { users.add(u); }
    public void deleteByEmail(String email) { users.removeIf(u->u.getEmail().equals(email)); }
}