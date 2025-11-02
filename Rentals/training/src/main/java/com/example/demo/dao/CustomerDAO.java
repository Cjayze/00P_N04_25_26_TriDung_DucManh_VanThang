package com.example.demo.dao;

import com.example.demo.model.Customer;
import java.util.*;

public class CustomerDAO {
    private final List<Customer> customers = new ArrayList<>();

    public CustomerDAO() {
        customers.add(new Customer(1, "Nguyen Van A", "a@gmail.com"));
        customers.add(new Customer(2, "Le Thi B", "b@gmail.com"));
        customers.add(new Customer(3, "Tran Van C", "c@gmail.com"));
    }

    public List<Customer> getAll() { return customers; }
    public Customer getById(int id) { return customers.stream().filter(c->c.getId()==id).findFirst().orElse(null); }
    public void add(Customer c) { customers.add(c); }
    public void update(Customer c) {
        for (int i=0;i<customers.size();i++) {
            if (customers.get(i).getId()==c.getId()) { customers.set(i,c); return; }
        }
    }
    public void delete(int id) { customers.removeIf(c->c.getId()==id); }
}