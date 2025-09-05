package com.shop;

import com.shop.model.*;

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product(1, "Laptop", 1000, 10, "Gaming laptop", "laptop.jpg");
        Product p2 = new Product(2, "Phone", 500, 20, "Smartphone", "phone.jpg");

        Customer c1 = new Customer(1, "Manh", "manh@mail.com", "123", "Hà Nội", "0123456789");

        c1.addToCart(p1, 1);
        c1.addToCart(p2, 2);

        Order order = c1.checkout();
        order.createOrder();

        Admin admin = new Admin(99, "Admin", "admin@mail.com", "admin");
        admin.manageOrder(order);
    }
}
