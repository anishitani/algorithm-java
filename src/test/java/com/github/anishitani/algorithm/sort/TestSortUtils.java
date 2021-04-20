package com.github.anishitani.algorithm.sort;

import java.util.List;

public class TestSortUtils {

    public static <T extends Comparable<T>> boolean isSorted(List<T> list) {
        for(int i = 1 ; i<list.size() ; i++) {
            T last = list.get(i-1);
            T curr = list.get(i);
            if(last.compareTo(curr) > 0) return false;
        }
        return true;
    }
}
