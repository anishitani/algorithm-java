package com.github.anishitani.algorithm.sort;

import java.util.List;

public interface Sort<T extends Comparable<T>> {
    boolean sort(List<T> unsorted);
}
