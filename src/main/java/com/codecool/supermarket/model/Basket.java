package com.codecool.supermarket.model;

import java.util.LinkedList;
import java.util.List;

public class Basket {

    private List<Product> productList;

    public Basket() {
        productList = new LinkedList<>();
    }
}
