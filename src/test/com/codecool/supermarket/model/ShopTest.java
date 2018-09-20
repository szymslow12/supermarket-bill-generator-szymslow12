package com.codecool.supermarket.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    @Test
    void shouldLoadProducts() {
        Shop shop = new Shop("src/main/resources/test_products.csv");


    }
}