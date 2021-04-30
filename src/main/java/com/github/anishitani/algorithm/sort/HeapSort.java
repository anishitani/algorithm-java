package com.github.anishitani.algorithm.sort;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HeapSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public boolean sort(List<T> unsorted) {
        maxHeap(unsorted);
        for (int i = unsorted.size() - 1; i > 0; i--) {
            Collections.swap(unsorted, 0, i);
            heapify(unsorted.subList(0, i), 0);
        }
        return true;
    }

    private void maxHeap(List<T> unsorted) {
        Set<Integer> visitedParents = new HashSet<>();
        for (int i = unsorted.size() - 1; i > 0; i--) {
            int p = parent(i);
            if (!visitedParents.contains(i)) {
                visitedParents.add(i);
                heapify(unsorted, p);
            }
        }
    }

    private void heapify(List<T> unsorted, int pIdx) {
        int lIdx = pIdx * 2 + 1;
        int rIdx = pIdx * 2 + 2;

        int greater;

        if (rIdx < unsorted.size()) {
            greater = unsorted.get(lIdx).compareTo(unsorted.get(rIdx)) > 0 ? lIdx : rIdx;
        } else if (lIdx < unsorted.size()) {
            greater = lIdx;
        } else {
            return;
        }

        if (unsorted.get(greater).compareTo(unsorted.get(pIdx)) > 0) {
            Collections.swap(unsorted, pIdx, greater);
            heapify(unsorted, greater);
        }
    }

    private int parent(int node) {
        return (node - 1) / 2;
    }
}
