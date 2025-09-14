package org.skypro.skyshop.search;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {
    private final Searchable[] searchables;
    private int itemCount;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.itemCount = 0;
    }

    public void add(Searchable searchable) {
        if (itemCount < searchables.length) {
            searchables[itemCount] = searchable;
            itemCount++;
        } else {
            System.out.println("Невозможно добавить больше элементов в поисковый движок");
        }
    }

    public List<Searchable> search(String query) {
        List<Searchable> results = new ArrayList<>();
        String lowerCaseQuery = query.toLowerCase();

        for (int i = 0; i < itemCount && results.size() < 5; i++) {
            Searchable item = searchables[i];
            if (item.getSearchTerm().toLowerCase().contains(lowerCaseQuery)) {
                results.add(item);
            }
        }

        return results;
    }
}