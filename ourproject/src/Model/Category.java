package com.shop.model;

public class Category {
    private int categoryId;
    private String name;
    private String description;

    public Category(int categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public void addCategory() { System.out.println("Category added: " + name); }
    public void updateCategory() { System.out.println("Category updated: " + name); }
    public void deleteCategory() { System.out.println("Category deleted: " + name); }

    public String getName() { return name; }
}
