package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private Set<Searchable> searchables; // Заменяем List на Set

    public SearchEngine() {
        this.searchables = new HashSet<>(); // Используем HashSet
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable); // Автоматически предотвращает дубликаты
    }

    public Set<Searchable> search(String term) {
        Set<Searchable> results = new TreeSet<>(new SearchableComparator());
        for (Searchable s : searchables) {
            if (s.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }
}