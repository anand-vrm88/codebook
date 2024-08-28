package com.codebook.misc;

import java.util.HashSet;
import java.util.Set;

public class BuildSubset {

    private static void generateSubset(int[] numbers, int index, Set<Integer> set) {
        if (index >= numbers.length) {
            System.out.println(set);
            return;
        }

        generateSubset(numbers, index + 1, new HashSet<>(set));
        HashSet<Integer> updatedSet = new HashSet<>(set);
        updatedSet.add(numbers[index]);
        generateSubset(numbers, index + 1, updatedSet);
    }

    private static void generateSubset(int n) {
        int[] numbers = new int[n];
        for (int index = 0; index < n; index++) {
            numbers[index] = index + 1;
        }

        generateSubset(numbers, 0, new HashSet<>());
    }

    public static void main(String[] args) {
        generateSubset(4);
    }
}
