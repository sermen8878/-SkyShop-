import java.util.Arrays;

public static void main(String[] args) {
    // Создание продуктов разных типов
    SimpleProduct laptop = new SimpleProduct("Ноутбук", 150000);
    DiscountedProduct mouse = new DiscountedProduct("Мышь", 2500, 10);
    FixPriceProduct keyboard = new FixPriceProduct("Клавиатура");
    SimpleProduct monitor = new SimpleProduct("Монитор", 80000);
    DiscountedProduct headphones = new DiscountedProduct("Наушники", 7000, 15);
    FixPriceProduct webcam = new FixPriceProduct("Веб-камера");

    // Создание статей
    Article laptopArticle = new Article("Обзор ноутбука",
            "Новый ноутбук обладает повышенной производительностью и долгим временем работы от батареи.");
    Article mouseArticle = new Article("Выбор мыши",
            "Как выбрать оптимальную мышь для работы и игр.");

    // Создание корзины
    ProductBasket basket = new ProductBasket();

    // Добавление продуктов в корзину
    basket.addProduct(laptop);
    basket.addProduct(mouse);
    basket.addProduct(keyboard);
    basket.addProduct(monitor);
    basket.addProduct(headphones);
    basket.addProduct(webcam);

    // Печать содержимого корзины
    basket.printBasket();

    // Создание поискового движка
    org.skypro.skyshop.search.SearchEngine searchEngine = new org.skypro.skyshop.search.SearchEngine(20);

    // Добавление продуктов и статей в поисковый движок
    searchEngine.add(laptop);
    searchEngine.add(mouse);
    searchEngine.add(keyboard);
    searchEngine.add(monitor);
    searchEngine.add(headphones);
    searchEngine.add(webcam);
    searchEngine.add(laptopArticle);
    searchEngine.add(mouseArticle);

    // Демонстрация поиска
    System.out.println("\n=== Результаты поиска по запросу 'ноутбук' ===");
    org.skypro.skyshop.search.Searchable[] results = searchEngine.search("ноутбук");
    System.out.println(Arrays.toString(results));

    System.out.println("\n=== Результаты поиска по запросу 'мышь' ===");
    results = searchEngine.search("мышь");
    System.out.println(Arrays.toString(results));

    System.out.println("\n=== Результаты поиска по запросу 'выбор' ===");
    results = searchEngine.search("выбор");
    System.out.println(Arrays.toString(results));

    // Демонстрация других методов
    System.out.println("\n=== Демонстрация методов ===");
    System.out.println("Общая стоимость: " + basket.getTotalCost());
    System.out.println("Есть ли мышь в корзине? " + basket.containsProduct("Мышь"));

    // Очистка корзины
    basket.clearBasket();
    basket.printBasket();
}
