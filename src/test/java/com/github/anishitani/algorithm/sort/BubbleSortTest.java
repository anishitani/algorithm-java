package com.github.anishitani.algorithm.sort;

public class BubbleSortTest extends AbstractSortTest {
    @Override
    protected <T extends Comparable<T>> Sort<T> sorter(Class<T> classType) {
        return new BubbleSort<T>();
    }
}
