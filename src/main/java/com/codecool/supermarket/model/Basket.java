package com.codecool.supermarket.model;

import java.util.LinkedList;
import java.util.List;

public class Basket {

    private List<Product> productList;

    public Basket() {
        productList = new LinkedList<>();
    }


    public void add(Product product) {
        if (product == null) {
            return;
        }
        productList.add(product);
    }


    public int size() {
        return productList.size();
    }


    public void remove(String productName) {
        if (productName == null) {
            return;
        }
        List<Product> productListCopy = new LinkedList<>();
        productListCopy.addAll(productList);
        for (Product product: productListCopy) {
            if (product.getName().equals(productName)) {
                productList.remove(product);
            }
        }
    }


    public List<Product> getBasketProducts() {
        return productList;
    }
}
