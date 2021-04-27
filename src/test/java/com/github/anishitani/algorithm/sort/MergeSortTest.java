package com.github.anishitani.algorithm.sort;

public class MergeSortTest extends AbstractSortTest {
    @Override
    protected <T extends Comparable<T>> Sort<T> sorter(Class<T> classType) {
        return new MergeSort<T>();
    }
}
