package com.github.anishitani.algorithm.sort;

import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public boolean sort(List<T> unsorted) {
        if (unsorted.isEmpty()) return true;
        if (unsorted.size() == 1) return true;

        boolean clean = false;
        while (!clean) {
            clean = true;
            T current = unsorted.get(0);
            for (int i = 1; i < unsorted.size(); i++) {
                T last = current;
                current = unsorted.get(i);
                if (last.compareTo(current) > 0) {
                    clean = false;
                    Collections.swap(unsorted, i - 1, i);
                }
            }
        }
        return true;
    }

}
