package com.codecool.supermarket;

import com.codecool.supermarket.model.Basket;
import com.codecool.supermarket.model.Shop;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(Arrays.toString(args));
        if (args.length == 2) {
            String pathToResource = "src/main/resources/";
            Shop shop = new Shop(pathToResource + args[0]);
            Basket basket = new Basket();
            basket.loadBasketProducts(pathToResource + args[1]);
            System.out.println("The total price is: " + shop.calculateBill(basket));
        }
    }
}
