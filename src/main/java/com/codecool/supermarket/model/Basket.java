package com.codecool.supermarket.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Basket {

    private List<Product> productList;

    public Basket() {
        productList = new LinkedList<>();
    }


    public void loadBasketProducts(String filePath) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(filePath));
        int barcode;
        while (scanner.hasNext()) {
            barcode = Integer.parseInt(scanner.nextLine().trim());
            addProduct(barcode);
        }
        scanner.close();
    }


    private void addProduct(int barcode) {
        for (Product product: productList) {
            if (product.getBarcode() == barcode) {
                product.setAmount(product.getAmount() + 1);
                return;
            }
        }
        add(new Product(barcode));
    }

    public void add(Product product) {
        if (product == null) {
            return;
        }
        productList.add(product);
    }


    public int size() {
        int size = 0;
        for (Product product: productList) {
            size += product.getAmount();
        }
        return size;
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
