package com.codecool.supermarket.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class ShopTest {

    @Mock
    private Basket basket;
    private Shop shop = new Shop("src/main/resources/test-products.csv");

    @BeforeEach
    void setup() {
        initMocks(this);
        List<Product> products = new LinkedList<>();
        products.add(new Product(1));
        products.add(new Product(2));
        products.get(1).setAmount(2);
        when(basket.getBasketProducts()).thenReturn(products);
    }

    @Test
    void shouldLoadProducts() {
        int expected = 3;
        int actual = shop.getProductsList().size();

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateBillFromNonEmptyBasket() {
        float expected = 4.00f;
        float actual = shop.calculateBill(basket);

        assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateBillFromEmptyBasket() {
        float expected = 0f;
        float actual = shop.calculateBill(new Basket());

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateBillThrowsExceptionIfNullPassed() {
        assertThrows(IllegalArgumentException.class, () -> shop.calculateBill(null));
    }
}