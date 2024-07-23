package com.electronics.inventory;

public class Product {
    private String name;
    private String category;
    private int quantity;
    private String location;
    private double price;

    public Product(String name, String category, int quantity, String location, double price) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.location = location;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getLocation() {
        return location;
    }

    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
