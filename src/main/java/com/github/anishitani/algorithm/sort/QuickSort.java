package com.github.anishitani.algorithm.sort;

import java.util.ArrayList;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public boolean sort(List<T> unsorted) {
        List<T> sorted = quicksort(unsorted);
        unsorted.clear();
        unsorted.addAll(sorted);
        return true;
    }

    private List<T> quicksort(List<T> unsorted) {
        if(unsorted.size() < 2) return unsorted;

        T pivot = unsorted.get(0);
        int left = 0;

        for (int i = 1; i < unsorted.size(); i++) {
            T el = unsorted.remove(i);
            if (pivot.compareTo(el) > 0) {
                unsorted.add(0, el);
                left++;
            } else {
                unsorted.add(el);
            }
        }

        quicksort(unsorted.subList(0,left));
        quicksort(unsorted.subList(left+1, unsorted.size()));

        return unsorted;
    }

}
