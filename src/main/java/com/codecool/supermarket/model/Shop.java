package com.codecool.supermarket.model;

import java.util.LinkedList;
import java.util.List;

public class Shop {

    private List<Product> products;

    public Shop(String pathToFile) {
        products = loadProducts(pathToFile);
    }

    private List<Product> loadProducts(String pathToFile) {
        List<Product> products = new LinkedList<>();
        return products;
    }


    public List<Product> getProductsList() {
        return products;
    }
}
