package com.codecool.supermarket.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket getFilledBasket() {
        Basket basket = new Basket();
        basket.add(new Product("product", 1));
        basket.add(new Product("product2", 2));
        basket.add(new Product("product3", 3));
        return new Basket();
    }


    @Test
    void shouldAddProduct() {
        Basket basket = new Basket();

        basket.add(new Product("name", 10));

        int expected = 1;
        int actual = basket.getSize();

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotAddNull() {
        Basket basket = new Basket();

        basket.add(null);

        int expected = 0;
        int actual = basket.getSize();

        assertEquals(expected, actual);
    }
}