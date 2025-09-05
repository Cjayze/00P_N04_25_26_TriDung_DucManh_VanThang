package com.shop.model;

public class Admin extends User {
    public Admin(int userId, String name, String email, String password) {
        super(userId, name, email, password);
    }

    public void manageProduct(Product product) {
        System.out.println("Managing product: " + product.getName());
    }

    public void manageCategory(Category category) {
        System.out.println("Managing category: " + category.getName());
    }

    public void manageOrder(Order order) {
        System.out.println("Managing order: " + order.getOrderId());
    }
}
