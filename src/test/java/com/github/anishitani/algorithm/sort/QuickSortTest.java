package com.github.anishitani.algorithm.sort;

public class QuickSortTest extends AbstractSortTest {
    @Override
    protected <T extends Comparable<T>> Sort<T> sorter(Class<T> classType) {
        return new QuickSort<>();
    }
}
