package org.skypro.skyshop;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import java.util.Arrays;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
        // Создание продуктов разных типов
        SimpleProduct laptop = new SimpleProduct("Ноутбук", 150000);
        DiscountedProduct mouse = new DiscountedProduct("Мышь", 2500, 10);
        FixPriceProduct keyboard = new FixPriceProduct("Клавиатура");
        SimpleProduct monitor = new SimpleProduct("Монитор", 80000);
        DiscountedProduct headphones = new DiscountedProduct("Наушники", 7000, 15);
        FixPriceProduct webcam = new FixPriceProduct("Веб-камера");

        // Создание корзины
        ProductBasket basket = new ProductBasket();

        // Добавление продуктов
        basket.addProduct(laptop);
        basket.addProduct(mouse);
        basket.addProduct(keyboard);
        basket.addProduct(monitor);
        basket.addProduct(headphones);
        basket.addProduct(webcam); // Попытка добавить в заполненную корзину

        // Печать содержимого корзины
        basket.printBasket();

        // Демонстрация других методов
        System.out.println("Общая стоимость: " + basket.getTotalCost());
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