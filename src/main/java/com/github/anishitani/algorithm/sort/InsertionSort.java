package com.github.anishitani.algorithm.sort;

import com.github.anishitani.algorithm.search.BinarySearch;

import java.util.List;

import static java.lang.Math.abs;

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {
    private BinarySearch<T> searcher;

    public InsertionSort() {
        this.searcher = new BinarySearch<>();
    }

    @Override
    public boolean sort(List<T> unsorted) {
        for (int i = 1; i < unsorted.size(); i++) {
            T next = unsorted.remove(i);
            int pos = searcher.search(next, unsorted.subList(0, i));
            unsorted.add(abs(pos), next);
        }
        return true;
    }

}
