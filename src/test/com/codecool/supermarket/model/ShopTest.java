package com.codecool.supermarket.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    private Shop shop = new Shop("src/main/resources/test-products.csv");

    @Test
    void shouldLoadProducts() {
        int expected = 2;
        int actual = shop.getProductsList().size();

        assertEquals(expected, actual);
    }
}