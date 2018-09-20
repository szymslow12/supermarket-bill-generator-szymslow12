package com.codecool.supermarket.model;

public class Product {

    private String name = null;
    private int barcode;
    private float price = 0;
    private int amount = 1;
    private boolean isOnPromotion = false;


    public Product(String name, int barcode) {
        this.name = name;
        this.barcode = barcode;
    }


    public Product(String name, int barcode, float price, int amount, boolean isOnPromotion) {
        this(name, barcode);
        this.amount = amount;
        this.price = price;
        this.isOnPromotion = isOnPromotion;
    }


    public Product(String name) {
        this.name = name;
    }


    public Product(int barcode) {
        this.barcode = barcode;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public float getPrice() {
        return price;
    }


    public void setPrice(float price) {
        this.price = price;
    }


    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


    public int getBarcode() {
        return barcode;
    }


    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }


    public boolean isOnPromotion() {
        return isOnPromotion;
    }


    public void setOnPromotion(boolean onPromotion) {
        isOnPromotion = onPromotion;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Price: %s, Amount: %s", name, price, amount);
    }
}
