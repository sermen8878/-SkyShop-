package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

public class ProductBasket {
    private final Product[] products;
    private int itemCount;

    public ProductBasket() {
        this.products = new Product[5];
        this.itemCount = 0;
    }

    public void addProduct(Product product) {
        if (itemCount >= products.length) {
            System.out.println("Невозможно добавить продукт");
            return;
        }
        products[itemCount] = product;
        itemCount++;
    }

    public int getTotalCost() {
        int total = 0;
        for (int i = 0; i < itemCount; i++) {
            total += products[i].getCost();
        }
        return total;
    }

    public void printBasket() {
        if (itemCount == 0) {
            System.out.println("в корзине пусто");
            return;
        }
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].getName() + ": " + products[i].getCost());
        }
        System.out.println("Итого: " + getTotalCost());
    }

    public boolean containsProduct(String name) {
        for (int i = 0; i < itemCount; i++) {
            if (products[i].getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public void clearBasket() {
        for (int i = 0; i < itemCount; i++) {
            products[i] = null;
        }
        itemCount = 0;
    }
}