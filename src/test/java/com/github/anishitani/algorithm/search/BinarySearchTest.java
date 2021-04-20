package com.github.anishitani.algorithm.search;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTest {
    @Test
    public void shouldFindPositionInIntegerPositiveList() {
        List<Integer> list = IntStream.range(1, 10).boxed().collect(Collectors.toList());

        int pos = new BinarySearch<Integer>().search(5, list);
        assertEquals(5, pos, "Position should be 5");
    }

    @Test
    public void shouldFindPositionInIntegerList() {
        List<Integer> list = IntStream.range(-10, 10).boxed().collect(Collectors.toList());

        int pos = new BinarySearch<Integer>().search(5, list);
        assertEquals(16, pos, "Position should be 16");
    }

    @Test
    public void shouldFindLeftSidePositionInLongIntegerList() {
        List<Integer> list = IntStream.range(-100, 100).boxed().collect(Collectors.toList());

        int pos = new BinarySearch<Integer>().search(-95, list);
        assertEquals(6, pos, "Position should be 6");
    }

    @Test
    public void shouldFindRightSidePositionInLongIntegerList() {
        List<Integer> list = IntStream.range(-100, 100).boxed().collect(Collectors.toList());

        int pos = new BinarySearch<Integer>().search(95, list);
        assertEquals(196, pos, "Position should be 196");
    }

    @Test
    public void shouldFindInsertionPositionInLongIntegerList() {
        List<Integer> list = List.of(-2,-1,1,2);

        int pos = new BinarySearch<Integer>().search(0, list);
        assertEquals(-2, pos, "Position should be -2");
    }

    @Test
    public void shouldFindInsertPositionAsFirstInIntegerList() {
        List<Integer> list = List.of(-2,-1,1,2);

        int pos = new BinarySearch<Integer>().search(-10, list);
        assertEquals(0, pos, "Position should be 0");
    }

    @Test
    public void shouldFindInsertPositionAsLastInIntegerList() {
        List<Integer> list = List.of(-2,-1,1,2);

        int pos = new BinarySearch<Integer>().search(10, list);
        assertEquals(-4, pos, "Position should be 4");
    }
}