package com.github.anishitani.algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public boolean sort(List<T> unsorted) {
        List<T> merged = mergeSort(unsorted);
        unsorted.clear();
        unsorted.addAll(merged);
        return true;
    }

    private List<T> mergeSort(List<T> unsorted) {
        if (unsorted.size() < 2) return unsorted;

        int mid = unsorted.size() / 2;

        List<T> left = mergeSort(unsorted.subList(0, mid));
        List<T> right = mergeSort(unsorted.subList(mid, unsorted.size()));

        return merge(left, right);
    }

    private List<T> merge(List<T> left, List<T> right) {
        List<T> merged = new ArrayList<>();
        int l = 0, r = 0;
        for (; l < left.size() && r < right.size(); ) {
            if (left.get(l).compareTo(right.get(r)) < 0) {
                merged.add(left.get(l++));
            } else {
                merged.add(right.get(r++));
            }
        }

        for(;l < left.size(); l++){
            merged.add(left.get(l));
        }

        for(;r < right.size(); r++){
            merged.add(right.get(r));
        }

        return merged;
    }
}
