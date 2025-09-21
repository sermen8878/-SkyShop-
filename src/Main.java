package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.SearchEngine;
import org.skypro.skyshop.search.Searchable;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Демонстрация работы с SearchEngine
        SearchEngine engine = new SearchEngine();

        // Добавляем продукты (дубликаты не добавятся)
        engine.addSearchable(new SimpleProduct("Яблоко", 50));
        engine.addSearchable(new SimpleProduct("Банан", 30));
        engine.addSearchable(new SimpleProduct("Яблоко", 50)); // Дубликат - не добавится

        // Добавляем статьи
        engine.addSearchable(new Article("Как выбрать фрукты", "Советы по выбору..."));
        engine.addSearchable(new Article("Польза яблок", "Яблоки очень полезны..."));

        // Поиск с сортировкой
        Set<Searchable> results = engine.search("ябл");
        System.out.println("Результаты поиска (отсортированы по длине имени):");
        for (Searchable s : results) {
            System.out.println(s.getName() + " - " + s.getContentType() +
                    " (длина: " + s.getName().length() + ")");
        }

        // Тестирование equals и hashCode
        Product product1 = new SimpleProduct("Тестовый продукт", 100);
        Product product2 = new SimpleProduct("Тестовый продукт", 150);
        System.out.println("\nТестирование equals: " + product1.equals(product2));
        System.out.println("HashCode сравнение: " +
                (product1.hashCode() == product2.hashCode()));
    }
}