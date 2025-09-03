package org.skypro.skyshop.search;

public class SearchEngine {
    private final Searchable[] searchables;
    private int itemCount;

    public SearchEngine(int capacity) {
        this.searchables = new Searchable[capacity];
        this.itemCount = 0;
    }

    public void add(Searchable searchable) {
        if (itemCount >= searchables.length) {
            System.out.println("Невозможно добавить элемент, достигнут лимит");
            return;
        }
        searchables[itemCount] = searchable;
        itemCount++;
    }

    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[5];
        int foundCount = 0;

        for (int i = 0; i < itemCount && foundCount < 5; i++) {
            if (searchables[i].getSearchTerm().toLowerCase().contains(query.toLowerCase())) {
                results[foundCount] = searchables[i];
                foundCount++;
            }
        }

        return results;
    }
}