package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;
import java.util.Objects;

public class Article implements Searchable {
    private final String name;
    private final String content;

    public Article(String name, String content) {
        this.name = name;
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(name, article.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "ARTICLE";
    }

    @Override
    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}

    // Реализация методов интерфейса Searchable
    @Override
    public String getSearchTerm() {
        // Для статей поисковым термином является объединение заголовка и текста
        return title + " " + text;
    }

    @Override
    public String getContentType() {
        // Для статей тип контента - ARTICLE
        return "ARTICLE";
    }

    @Override
    public String getName() {
        // Возвращаем заголовок статьи как имя
        return title;
    }

    @Override
    public String getStringRepresentation() {
        // Специальное представление для статей
        return "Статья: " + title + " [" + getContentType() + "]";
    }

    // Геттеры для доступа к полям
    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    // Переопределение toString для красивого вывода
    @Override
    public String toString() {
        return title + "\n" + text;
    }

    // Дополнительные методы
    public int getWordCount() {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        return text.split("\\s+").length;
    }

    public boolean containsKeyword(String keyword) {
        return text.toLowerCase().contains(keyword.toLowerCase()) ||
                title.toLowerCase().contains(keyword.toLowerCase());
    }
}