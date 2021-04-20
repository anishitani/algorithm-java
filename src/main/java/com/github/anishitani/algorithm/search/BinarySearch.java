package com.github.anishitani.algorithm.search;

import java.util.List;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {
    public int search(T target, List<T> sortedList) {
        int min = 0, max = sortedList.size();
        int halfIdx = (max - min) / 2;
        T half = sortedList.get(halfIdx);
        int comparisson = half.compareTo(target);
        if (comparisson < 0) {
            if(sortedList.size() == 1) return -1;
            min = halfIdx;
            int pos = search(target, sortedList.subList(min, max));
            return pos > 0 ? pos + halfIdx : pos - halfIdx;
        } else if (comparisson > 0) {
            if(sortedList.size() == 1) return 0;
            max = halfIdx;
            return search(target, sortedList.subList(min, max));
        } else {
            return halfIdx + 1;
        }
    }
}
