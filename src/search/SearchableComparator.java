package org.skypro.skyshop.search;

import java.util.Comparator;

public class SearchableComparator implements Comparator<Searchable> {
    @Override
    public int compare(Searchable s1, Searchable s2) {
        // Сравниваем по длине имени (от большего к меньшему)
        int lengthCompare = Integer.compare(
                s2.getName().length(),
                s1.getName().length()
        );

        // Если длины равны, сравниваем в натуральном порядке
        if (lengthCompare == 0) {
            return s1.getName().compareTo(s2.getName());
        }

        return lengthCompare;
    }
}