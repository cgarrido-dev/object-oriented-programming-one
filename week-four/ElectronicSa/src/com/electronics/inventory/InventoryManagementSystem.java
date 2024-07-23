package com.electronics.inventory;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        
        inventory.addProduct(new Product("Notebook", "Electronicos", 4, "Bodega 1", 1000.0));
        inventory.addProduct(new Product("Smartphone", "Electronicos", 5, "Bodega 1", 800.0));
        inventory.addProduct(new Product("Camara", "Electronicos", 3, "Bodega 2", 500.0));
        inventory.addProduct(new Product("Televisor", "Electronicos", 2, "Bodega 4", 1500.0));
        inventory.addProduct(new Product("Cubiertos", "Cocina", 3, "Bodega 4", 100.0));
        inventory.addProduct(new Product("Vasos", "Cocina", 9, "Bodega 4", 990.0));
        inventory.addProduct(new Product("Toallas", "Baño", 10, "Bodega 4", 5990.0));

        System.out.println(" * Ejecución Pregunta 1\n");
        inventory.checkProductAvailability("Notebook");
        inventory.applyDiscount("Camara", 10);
        inventory.checkProductLocation("Smartwatch");
        inventory.checkProductLocation("Vasos");
        
        System.out.println("\n\n * Ejecución Pregunta 2\n");
        inventory.checkProductQuantity("Notebook");
        inventory.applyCategoryDiscount("Electronicos", 500, 15);
        
        System.out.println("\n\n * Ejecución Pregunta 3\n");
        inventory.applyCategoryDiscountsSwitchCase();
    }
}