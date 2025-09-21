package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private List<Searchable> searchables; // Заменяем массив на список

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void addSearchable(Searchable searchable) {
        searchables.add(searchable);
    }

    // Возвращаем все подходящие результаты
    public List<Searchable> search(String term) {
        List<Searchable> results = new ArrayList<>();
        for (Searchable s : searchables) {
            if (s.getSearchTerm().toLowerCase().contains(term.toLowerCase())) {
                results.add(s);
            }
        }
        return results;
    }
}