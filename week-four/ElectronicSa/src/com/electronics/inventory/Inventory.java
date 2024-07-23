package com.electronics.inventory;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void checkProductAvailability(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                if (product.getQuantity() > 0) {
                    System.out.println("Producto: " + productName + " está disponible con la cantidad: " + product.getQuantity());
                } else {
                    System.out.println("Producto: " + productName + " está agotado.");
                }
                return;
            }
        }
        System.out.println("Producto: " + productName + " no se encuentra en el inventario.");
    }

    public void applyDiscount(String productName, double discountPercentage) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                double newPrice = product.getPrice() * (1 - discountPercentage / 100);
                product.setPrice(newPrice);
                System.out.println("Nuevo precio de " + productName + " después de " + discountPercentage + "% descuento es: $" + newPrice);
                return;
            }
        }
        System.out.println("Product: " + productName + " no se encuentra en el inventario.");
    }

    public void checkProductLocation(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                System.out.println("Producto: " + productName + " se encuentra en: " + product.getLocation());
                return;
            }
        }
        System.out.println("Producto: " + productName + " no se encuentra en el inventario.");
    }
    
    public void checkProductQuantity(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {

                if (product.getQuantity() < 5) {
                    System.out.println("Producto: " + productName + " tiene pocas existencias. Cantidad actual: " + product.getQuantity());
                }
                return;
            }
        }
        System.out.println("Producto: " + productName + " no se encuentra en el inventario.");
    }
    
    public void applyCategoryDiscount(String categoryName, double priceThreshold, double discountPercentage) {
        for (Product product : products) {
            if (product.getCategory().equalsIgnoreCase(categoryName)) {

                if (product.getPrice() > priceThreshold) {
                    double newPrice = product.getPrice() * (1 - discountPercentage / 100);
                    product.setPrice(newPrice);
                    System.out.println("Nuevo precio de " + product.getName() + " después de " + discountPercentage + "% descuento es: $" + newPrice);
                } else {
                    System.out.println("Producto: " + product.getName() + " no tiene derecho al descuento.");
                }
            }
        }
    }
    

    public void applyCategoryDiscountsSwitchCase() {
        for (Product product : products) {
            double discountPercentage = 0;
            switch (product.getCategory().toLowerCase()) {
                case "electronicos":
                    discountPercentage = 10;
                    break;
                case "cocina":
                    discountPercentage = 5;
                    break;
                default:
                    System.out.println("No hay descuento por categoría: " + product.getCategory());
                    continue;
            }
            
            applyDiscount(product, discountPercentage);
        }
    }

    private void applyDiscount(Product product, double discountPercentage) {
        double newPrice = product.getPrice() * (1 - discountPercentage / 100);
        product.setPrice(newPrice);
        System.out.println("Nuevo precio de " + product.getName() + " despues de " + discountPercentage + "% descuento es: $" + newPrice);
    }
}
