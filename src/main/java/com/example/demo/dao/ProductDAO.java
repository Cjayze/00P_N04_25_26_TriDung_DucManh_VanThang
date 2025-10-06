package com.example.demo.dao;

import com.example.demo.model.Product;
import java.util.*;

public class ProductDAO {
    private final List<Product> products = new ArrayList<>();

    public ProductDAO() {
        products.add(new Product(1, "Laptop", 1500));
        products.add(new Product(2, "Phone", 900));
        products.add(new Product(3, "Headphones", 120));
    }

    public List<Product> getAll() { return products; }
    public Product getById(int id) { return products.stream().filter(p -> p.getId()==id).findFirst().orElse(null); }
    public void add(Product p) { products.add(p); }
    public void update(Product p) {
        for (int i=0;i<products.size();i++) {
            if (products.get(i).getId()==p.getId()) { products.set(i,p); return; }
        }
    }
    public void delete(int id) { products.removeIf(p->p.getId()==id); }
}