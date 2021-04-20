package com.github.anishitani.algorithm;

import com.github.anishitani.algorithm.sort.BubbleSort;
import com.github.anishitani.algorithm.sort.Sort;

import java.time.Instant;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Random rnd = new Random(Instant.now().getEpochSecond());
        int length = 100, min = 0, max = 100;
        List<Integer> unsorted = rnd.ints(length, min, max).boxed().collect(Collectors.toList());
        Sort<Integer> sorter = new BubbleSort<>();
        if (sorter.sort(unsorted)) System.out.println(unsorted);
    }
}
