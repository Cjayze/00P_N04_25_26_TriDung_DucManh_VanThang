package com.example.demo.api;

import com.example.demo.dao.CustomerDAO;
import com.example.demo.model.Customer;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {
    private final CustomerDAO dao = new CustomerDAO();

    @GetMapping
    public List<Customer> all() { return dao.getAll(); }

    @GetMapping("/{id}")
    public Customer get(@PathVariable int id) { return dao.getById(id); }

    @PostMapping
    public String add(@RequestBody Customer c) { dao.add(c); return "Customer added"; }

    @PutMapping("/{id}")
    public String update(@PathVariable int id, @RequestBody Customer c) { c.setId(id); dao.update(c); return "Customer updated"; }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) { dao.delete(id); return "Customer deleted"; }
}