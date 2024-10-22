package com.pluralsight;

public class Product {
    String id;
    int stock;
    String name;
    String description;
    String productCode;

    public Product(String id, int stock, String name, String description, String productCode) {
        this.id = id;
        this.stock = stock;
        this.name = name;
        this.description = description;
        this.productCode = productCode;
    }

    public String getSupplierCode() {
        String[] code = this.productCode.split("-");
        return code[0];
    }

    public void order(int amount) {
        if (stock > amount) {
            System.out.println("Order has been made for " + amount + " " + name);
            this.stock -= amount;
        } else {
            System.out.println("We do not have that amount in stock.");
        }
    }

    public void order(int[] amounts) {
        for (int amount : amounts) {
            order(amount);
        }
    }
}
