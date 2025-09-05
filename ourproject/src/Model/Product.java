package com.shop.model;

public class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;
    private String description;
    private String image;

    public Product(int productId, String name, double price, int quantity, String description, String image) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.image = image;
    }

    public void addProduct() { System.out.println("Added product: " + name); }
    public void updateProduct() { System.out.println("Updated product: " + name); }
    public void deleteProduct() { System.out.println("Deleted product: " + name); }

    public String getName() { return name; }
    public double getPrice() { return price; }
}
