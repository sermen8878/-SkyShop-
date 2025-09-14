package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> productsMap;

    public ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void add(Product product) {
        String productName = product.getName();
        productsMap.computeIfAbsent(productName, k -> new ArrayList<>()).add(product);
    }

    public int getTotalCost() {
        int total = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                total += product.getPrice();
            }
        }
        return total;
    }

    public void printContents() {
        if (productsMap.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (List<Product> productList : productsMap.values()) {
            for (Product product : productList) {
                System.out.println(product.toString());
                if (product.isSpecial()) {
                    specialCount++;
                }
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

    public boolean contains(String productName) {
        return productsMap.containsKey(productName);
    }

    public void clear() {
        productsMap.clear();
    }

    public List<Product> removeByName(String name) {
        List<Product> removedProducts = productsMap.getOrDefault(name, new ArrayList<>());
        productsMap.remove(name);
        return new ArrayList<>(removedProducts);
    }
}