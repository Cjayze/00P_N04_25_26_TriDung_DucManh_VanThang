package com.example.demo.api;

import com.example.demo.dao.UserDAO;
import com.example.demo.model.User;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserApi {
    private final UserDAO dao = new UserDAO();

    @GetMapping
    public List<User> all() { return dao.getAll(); }

    @PostMapping
    public String add(@RequestBody User u) { dao.add(u); return "User added"; }

    @DeleteMapping
    public String delete(@RequestParam String email) { dao.deleteByEmail(email); return "User deleted"; }
}