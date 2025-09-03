package org.skypro.skyshop.product;

public abstract class Product {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract int getPrice();
    public abstract boolean isSpecial();
}package org.skypro.skyshop.product;

import org.skypro.skyshop.search.Searchable;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        this.name = name;
    }

    // Реализация методов интерфейса Searchable
    @Override
    public String getSearchTerm() {
        // Для товаров поисковым термином является название товара
        return name;
    }

    @Override
    public String getContentType() {
        // Для всех товаров тип контента - PRODUCT
        return "PRODUCT";
    }

    @Override
    public String getName() {
        // Возвращаем название товара
        return name;
    }

    @Override
    public String getStringRepresentation() {
        // Переопределяем default метод для более информативного вывода
        return getName() + " [" + getContentType() + "] - Цена: " + getPrice();
    }

    // Абстрактные методы, которые должны быть реализованы в подклассах
    public abstract int getPrice();
    public abstract boolean isSpecial();

    // Дополнительный метод для удобства
    @Override
    public String toString() {
        return getStringRepresentation();
    }
}