package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.Product; // Добавлен импорт
import java.util.List; // Добавлен импорт

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
        basket.addProduct(webcam);

        // Печать содержимого корзины
        basket.printBasket();

        // Демонстрация других методов
        System.out.println("Общая стоимость: " + basket.getTotalCost());
        System.out.println("Есть ли мышь в корзине? " + basket.containsProduct("Мышь"));
        System.out.println("Есть ли веб-камера в корзине? " + basket.containsProduct("Веб-камера"));

        // Очистка корзины
        basket.clearBasket();

        // Демонстрация удаления продуктов по имени
        System.out.println("\n=== Удаление продуктов по имени ===");

        // Добавляем несколько одинаковых продуктов для демонстрации
        Product apple = new SimpleProduct("Яблоко", 55); // Исправлено создание продукта
        basket.addProduct(apple); // Исправлен метод добавления

        System.out.println("Содержимое корзины до удаления:");
        basket.printBasket(); // Исправлен метод печати

        // Удаляем все продукты с именем "Яблоко"
        List<Product> removedProducts = basket.removeByName("Яблоко");
        System.out.println("Удалено продуктов: " + removedProducts.size());
        for (Product product : removedProducts) {
            System.out.println("Удален: " + product.getName() + " - " + product.getPrice());
        }

        System.out.println("Содержимое корзины после удаления:");
        basket.printBasket();

        // Попытка удаления несуществующего продукта
        System.out.println("\n=== Попытка удаления несуществующего продукта ===");
        List<Product> notFoundRemoved = basket.removeByName("Ананас");
        if (notFoundRemoved.isEmpty()) {
            System.out.println("Список пуст - продукты не найдены");
        }

        // Демонстрация поиска (возвращает все результаты)
        System.out.println("\n=== Поиск всех результатов ===");

        // Создаем движок поиска
        SearchEngine searchEngine = new SearchEngine(); // Добавлено создание экземпляра

        // Добавим несколько статей для демонстрации
        Article appleArticle = new Article("Польза яблок",
                "Яблоки богаты витаминами и минералами. Они полезны для здоровья.");
        Article milkArticle = new Article("О молоке",
                "Молоко содержит кальций, необходимый для крепких костей.");

        searchEngine.add(appleArticle);
        searchEngine.add(milkArticle);

        List<Searchable> searchResults = searchEngine.search("молоко");
        System.out.println("Найдено результатов: " + searchResults.size());
        for (Searchable result : searchResults) {
            System.out.println(result.getStringRepresentation());
        }

        // Поиск по другому запросу
        System.out.println("\n=== Поиск по запросу 'яблок' ===");
        List<Searchable> appleResults = searchEngine.search("яблок");
        System.out.println("Найдено результатов: " + appleResults.size());
        for (Searchable result : appleResults) {
            System.out.println(result.getStringRepresentation());
        }

        // Демонстрация пустой корзины
        basket.printBasket();
        System.out.println("Стоимость пустой корзины: " + basket.getTotalCost());
        System.out.println("Есть ли мышь в пустой корзине? " + basket.containsProduct("Мышь"));
    }
}