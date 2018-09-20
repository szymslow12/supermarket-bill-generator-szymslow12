package com.codecool.supermarket.model;

public class Product {

    private String name;
    private int price;
    private int amount = 1;


    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }


    public Product(String name, int price, int amount) {
        this(name, price);
        this.amount = amount;
    }


    public Product(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getPrice() {
        return price;
    }


    public void setPrice(int price) {
        this.price = price;
    }


    public int getAmount() {
        return amount;
    }


    public void setAmount(int amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return String.format("Name: %s, Price: %s, Amount: %s", name, price, amount);
    }
}
