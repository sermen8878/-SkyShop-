package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
public class ProductBasket {
    private final List<Product> products;
    private int itemCount;

    public ProductBasket() {
        this.products = new ArrayList<>();
    }
        this.itemCount = 0;
    }
public void clear() {
    products.clear();
}
public void printContents() {
    if (products.isEmpty()) {
        System.out.println("в корзине пусто");
        return;
    }

    int specialCount = 0;
    for (Product product : products) {
        System.out.println(product.toString());
        if (product.isSpecial()) {
            specialCount++;
        }
    }
    System.out.println("Итого: " + getTotalCost());
    System.out.println("Специальных товаров: " + specialCount);
}

    public int getTotalCost() {
        int total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    public void printBasket() {
        if (itemCount == 0) {
            System.out.println("в корзине пусто");
            return;
        }

        int specialCount = 0;
        for (int i = 0; i < itemCount; i++) {
            System.out.println(products[i].toString());
            if (products[i].isSpecial()) {
                specialCount++;
            }
        }
        System.out.println("Итого: " + getTotalCost());
        System.out.println("Специальных товаров: " + specialCount);
    }

public boolean contains(String productName) {
    for (Product product : products) {
        if (product.getName().equals(productName)) {
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
    }public List<Product> removeByName(String name) {
    List<Product> removedProducts = new ArrayList<>();
    Iterator<Product> iterator = products.iterator();

    while (iterator.hasNext()) {
        Product product = iterator.next();
        if (product.getName().equals(name)) {
            removedProducts.add(product);
            iterator.remove();
        }
    }

    return removedProducts;
}
