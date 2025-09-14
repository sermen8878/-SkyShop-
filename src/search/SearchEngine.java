package org.skypro.skyshop.search;

import java.util.*;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine() {
        this.searchables = new ArrayList<>();
    }

    public void add(Searchable searchable) {
        searchables.add(searchable);
    }

    public Map<String, Searchable> search(String query) {
        Map<String, Searchable> results = new TreeMap<>(); // TreeMap для автоматической сортировки по ключам
        String lowerCaseQuery = query.toLowerCase();

        for (Searchable item : searchables) {
            if (item.getSearchTerm().toLowerCase().contains(lowerCaseQuery)) {
                results.put(item.getName(), item);
            }
        }

        return results;
    }
}