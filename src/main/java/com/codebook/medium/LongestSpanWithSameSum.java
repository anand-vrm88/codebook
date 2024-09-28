package com.codebook.medium;

import java.util.Arrays;

public class LongestSpanWithSameSum {

    public static void main(String[] args) {
        System.out.println(
                findLongestSpan(
                        new int[]{0, 0, 1, 0},
                        new int[]{1, 1, 1, 1}
                )
        );
    }

    private static int findLongestSpan(int[] array1, int[] array2){
        int array1Sum = Arrays.stream(array1).sum();
        int array2Sum = Arrays.stream(array2).sum();

        return findLongestSpan(array1, array2, 0, array1.length - 1, array1Sum, array2Sum);
    }

    private static int findLongestSpan(int[] array1, int[] array2, int i, int j, int array1Sum, int array2Sum){
        if(j < i){
            return 0;
        }

        if(array1Sum == array2Sum){
            return j - i + 1;
        }

        return Math.max(
                findLongestSpan(array1, array2, i, j - 1, array1Sum - array1[j], array2Sum - array2[j]),
                findLongestSpan(array1, array2, i+1, j, array1Sum - array1[i], array2Sum - array2[i])
        );
    }
}
