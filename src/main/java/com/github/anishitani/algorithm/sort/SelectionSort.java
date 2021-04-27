package com.github.anishitani.algorithm.sort;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class SelectionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public boolean sort(List<T> unsorted) {
        for (int i = 0; i < unsorted.size() - 1; i++) {
            int minimum = findMinimum(unsorted.subList(i, unsorted.size()));
            Collections.swap(unsorted, i, minimum + i);
        }
        return true;
    }


    public int findMinimum(List<T> unsorted) {
        return IntStream.range(0, unsorted.size())
                .reduce((left, right) -> unsorted.get(left).compareTo(unsorted.get(right)) < 0 ? left : right)
                .orElse(-1);
    }

}
