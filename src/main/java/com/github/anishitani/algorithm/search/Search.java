package com.github.anishitani.algorithm.search;

import java.util.List;

public interface Search<T extends Comparable> {
    int search(T target, List<T> sortedList);
}
