package com.shop.model;

import com.shop.model.User;

public class Customer extends User {
    private String address;
    private String phone;

    private Cart cart = new Cart();

    public Customer(int userId, String name, String email, String password, String address, String phone) {
        super(userId, name, email, password);
        this.address = address;
        this.phone = phone;
    }

    public void viewProduct(Product product) {
        System.out.println("Viewing product: " + product.getName());
    }

    public void addToCart(Product product, int quantity) {
        cart.addItem(product, quantity);
    }

    public Order checkout() {
        Order order = new Order(cart);
        cart.clear();
        System.out.println("Checkout successful!");
        return order;
    }
}
