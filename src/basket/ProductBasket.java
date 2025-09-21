package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductBasket {
    private List<Product> products; // Заменяем массив на список

    public ProductBasket() {
        this.products = new ArrayList<>(); // Инициализация списка
    }

    public void addProduct(Product product) {
        products.add(product); // Добавление без проверки предела
    }

    // Метод удаления продуктов по имени
    public List<Product> removeProductsByName(String name) {
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

    public void printBasket() {
        for (Product product : products) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
    }
}