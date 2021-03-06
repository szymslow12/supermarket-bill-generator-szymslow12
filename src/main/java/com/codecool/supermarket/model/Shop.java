package com.codecool.supermarket.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Shop {

    private List<Product> products = new LinkedList<>();

    public Shop(String pathToFile) {
        try {
            loadProducts(pathToFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadProducts(String pathToFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(pathToFile));
        scanner.nextLine();
        String[] item;
        while (scanner.hasNext()) {
            item = scanner.nextLine().split(",");
            String name = item[1];
            int barcode = Integer.valueOf(item[0].trim());
            int amount = Integer.valueOf(item[2].trim());
            float price = Float.valueOf(item[3].trim());
            products.add(new Product(name, barcode, price, amount));
        }
        scanner.close();
    }


    public List<Product> getProductsList() {
        return products;
    }


    public float calculateBill(Basket basket) {
        if (basket == null) {
            throw new IllegalArgumentException("Didn't receive basket!");
        }
        float bill = 0f;
        List<Product> basketProducts = basket.getBasketProducts();
        for (Product basketProduct: basketProducts) {
            List<Product> shopProducts = findProducts(basketProduct.getBarcode());
            for (Product shopProduct: shopProducts) {
                while(basketProduct.getAmount() > 0 && shopProduct.getAmount() <= basketProduct.getAmount()) {
                    bill += shopProduct.getPrice();
                    basketProduct.setAmount(basketProduct.getAmount() - shopProduct.getAmount());
                }
            }
        }
        return Float.valueOf(String.format("%.4g", bill).replace(',', '.'));
    }


    private List<Product> findProducts(int barcode) {
        List<Product> toReturn = new LinkedList<>();
        for (Product product: products) {
            if (barcode == product.getBarcode()) {
                toReturn.add(product);
            }
        }
        sortDescByAmount(toReturn);
        return toReturn;
    }


    private void sortDescByAmount(List<Product> productList) {
        for (int i = 1; i < productList.size(); i++) {
            Product first = productList.get(i - 1);
            Product second = productList.get(i);
            if (first.getAmount() < second.getAmount()) {
                productList.set(i - 1, second);
                productList.set(i, first);
            }
        }
    }
}
