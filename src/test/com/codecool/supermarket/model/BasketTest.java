package com.codecool.supermarket.model;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class BasketTest {

    private Basket getFilledBasket() {
        Basket basket = new Basket();
        basket.add(new Product("product", 1));
        basket.add(new Product("product2", 2));
        basket.add(new Product("product3", 3));
        return basket;
    }


    @Test
    void shouldAddProduct() {
        Basket basket = new Basket();

        basket.add(new Product("name", 10));

        int expected = 1;
        int actual = basket.size();

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotAddNull() {
        Basket basket = new Basket();

        basket.add(null);

        int expected = 0;
        int actual = basket.size();

        assertEquals(expected, actual);
    }


    @Test
    void shouldRemoveProduct() {
        Basket basket = getFilledBasket();

        basket.remove("product");

        int expected = 2;
        int actual = basket.size();

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotRemoveNotExistProduct() {
        Basket basket = getFilledBasket();

        basket.remove("dont exist");

        int expected = 3;
        int actual = basket.size();

        assertEquals(expected, actual);
    }


    @Test
    void shouldNotRemoveNull() {
        Basket basket = getFilledBasket();

        basket.remove(null);

        int expected = 3;
        int actual = basket.size();

        assertEquals(expected, actual);
    }


    @Test
    void shouldLoadBasketFromFile() throws FileNotFoundException {
        Basket basket = new Basket();

        basket.loadBasketProducts("src/main/resources/test-basket.txt");

        int expected = 2;
        int actual = basket.size();

        assertEquals(expected, actual);
    }
}