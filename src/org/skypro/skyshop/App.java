package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // Создание продуктов
        Product laptop = new Product("Ноутбук", 150000);
        Product mouse = new Product("Мышь", 2500);
        Product keyboard = new Product("Клавиатура", 5000);
        Product monitor = new Product("Монитор", 80000);
        Product headphones = new Product("Наушники", 7000);
        Product webcam = new Product("Веб-камера", 3000);

        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Добавление продуктов
        basket.addProduct(laptop);
        basket.addProduct(mouse);
        basket.addProduct(keyboard);
        basket.addProduct(monitor);
        basket.addProduct(headphones);
        basket.addProduct(webcam); // Попытка добавить в заполненную корзину

        // Печать содержимого
        basket.printBasket();

        // Получение общей стоимости
        System.out.println("Общая стоимость: " + basket.getTotalCost());

        // Поиск товаров
        System.out.println("Есть ли мышь в корзине? " + basket.containsProduct("Мышь"));
        System.out.println("Есть ли веб-камера в корзине? " + basket.containsProduct("Веб-камера"));

        // Очистка корзины
        basket.clearBasket();

        // Демонстрация пустой корзины
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли мышь в пустой корзине? " + basket.containsProduct("Мышь"));
    }
}