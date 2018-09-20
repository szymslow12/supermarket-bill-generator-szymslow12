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
    }


    public List<Product> getProductsList() {
        return products;
    }


    public float calculateBill(Basket basket) {
        return 1f;
    }
}
