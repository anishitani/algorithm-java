package com.github.anishitani.algorithm.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

abstract class AbstractSortTest {
    private Random rnd;

    @BeforeEach
    public void set(){
        rnd = new Random(Instant.now().getEpochSecond());
    }

    abstract protected <T extends Comparable<T>> Sort<T> sorter(Class<T> classType);

    @Test
    public void givenShortIntegerArray_whenSorting_thenShouldHaveSortedArray() {
        List<Integer> target = givenShortIntegerRandomUnsortedArray();

        boolean sorted = sorter(Integer.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenLongIntegerArray_whenSorting_thenShouldHaveSortedArray() {
        List<Integer> target = givenLongIntegerRandomUnsortedArray();

        boolean sorted = sorter(Integer.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenShortDoubleArray_whenSorting_thenShouldHaveSortedArray() {
        List<Double> target = givenShortDoubleRandomUnsortedArray();

        boolean sorted = sorter(Double.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenLongDoubleArray_whenSorting_thenShouldHaveSortedArray() {
        List<Double> target = givenLongDoubleRandomUnsortedArray();

        boolean sorted = sorter(Double.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenSortedIntegerArray_whenSorting_thenShouldHaveSortedArray() {
        List<Integer> target = givenShortIntegerSortedArray();

        boolean sorted = sorter(Integer.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenEmptyArray_whenSorting_thenShouldHaveSortedArray() {
        List<Integer> target = givenEmptyArray();

        boolean sorted = sorter(Integer.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenSingleIntegerArray_whenSorting_thenShouldHaveSortedArray() {
        List<Integer> target = givenSingeIntegerArray();

        boolean sorted = sorter(Integer.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    @Test
    public void givenReverseArray_whenSorting_thenShouldHaveSortedArray() {
        List<Integer> target = givenReverseArray();

        boolean sorted = sorter(Integer.class).sort(target);

        assertTrue(sorted, "Should have successful return.");
        assertTrue(TestSortUtils.isSorted(target), "Should have a sorted a array.");
    }

    private List<Integer> givenShortIntegerRandomUnsortedArray() {
        return rnd.ints(10,0,100).boxed().collect(Collectors.toList());
    }

    private List<Integer> givenLongIntegerRandomUnsortedArray() {
        return rnd.ints(10000,0,100).boxed().collect(Collectors.toList());
    }

    private List<Integer> givenShortIntegerSortedArray() {
        return IntStream.range(0, 10000).boxed().collect(Collectors.toList());
    }

    private List<Double> givenShortDoubleRandomUnsortedArray() {
        return rnd.doubles(10,0,100).boxed().collect(Collectors.toList());
    }

    private List<Double> givenLongDoubleRandomUnsortedArray() {
        return rnd.doubles(10000,0,100).boxed().collect(Collectors.toList());
    }

    private List<Integer> givenEmptyArray() {
        return Collections.EMPTY_LIST;
    }

    private List<Integer> givenSingeIntegerArray() {
        return rnd.ints(1,0,100).boxed().collect(Collectors.toList());
    }

    private List<Integer> givenReverseArray() {
        return IntStream.range(0, 10000).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    }
}