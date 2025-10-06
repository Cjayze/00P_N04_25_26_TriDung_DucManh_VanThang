package com.example.demo.dao;

import com.example.demo.model.Order;
import java.util.*;

public class OrderDAO {
    private final List<Order> orders = new ArrayList<>();

    public OrderDAO() {
        orders.add(new Order(1,1,1,2));
        orders.add(new Order(2,2,2,1));
        orders.add(new Order(3,3,1,3));
    }

    public List<Order> getAll() { return orders; }
    public Order getById(int id) { return orders.stream().filter(o->o.getId()==id).findFirst().orElse(null); }
    public void add(Order o) { orders.add(o); }
    public void update(Order o) {
        for (int i=0;i<orders.size();i++) {
            if (orders.get(i).getId()==o.getId()) { orders.set(i,o); return; }
        }
    }
    public void delete(int id) { orders.removeIf(o->o.getId()==id); }
}