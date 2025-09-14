package org.skypro.skyshop.article;

import org.skypro.skyshop.search.Searchable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Article implements Searchable {
    // поля класса

    public Article(String title, String text, String author,
                   LocalDateTime publicationDate, Set<String> tags,
                   int readingTimeMinutes) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок статьи не может быть пустым или null");
        }
        if (text == null || text.isBlank()) {
            throw new IllegalArgumentException("Текст статьи не может быть пустым или null");
        }
        if (author == null || author.isBlank()) {
            throw new IllegalArgumentException("Автор статьи не может быть пустым или null");
        }

        this.title = title;
        this.text = text;
        this.author = author;
        this.publicationDate = publicationDate != null ? publicationDate : LocalDateTime.now();
        this.tags = tags != null ? new HashSet<>(tags) : new HashSet<>();
        this.readingTimeMinutes = readingTimeMinutes > 0 ? readingTimeMinutes : calculateReadingTime(text);
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