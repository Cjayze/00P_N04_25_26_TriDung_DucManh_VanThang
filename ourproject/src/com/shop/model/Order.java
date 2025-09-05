package com.shop.model;

import java.util.*;

public class Order {
    private static int idCounter = 1;
    private int orderId;
    private Date orderDate;
    private String status;
    private double total;
    private List<OrderDetail> orderDetails = new ArrayList<>();

    public Order(Cart cart) {
        this.orderId = idCounter++;
        this.orderDate = new Date();
        this.status = "Pending";
        for (CartItem item : cart.getItems()) {
            orderDetails.add(new OrderDetail(item.getProduct(), item.getProduct().getPrice(), item.getQuantity()));
        }
        this.total = cart.getTotal();
    }

    public void createOrder() {
        System.out.println("Order created with ID: " + orderId + " | Total: " + total);
    }

    public void updateStatus(String status) { this.status = status; }
    public int getOrderId() { return orderId; }
}
