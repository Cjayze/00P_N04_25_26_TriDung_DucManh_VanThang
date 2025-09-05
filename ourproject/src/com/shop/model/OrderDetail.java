package com.shop.model;

public class OrderDetail {
    private Product product;
    private int quantity;
    private double price;

    public OrderDetail(Product product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }
}
