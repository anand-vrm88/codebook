package com.codebook.medium;

import java.util.HashSet;
import java.util.Set;

public class ZeroSumSubArray {

    public static void main(String[] args) {
        System.out.println(findZeroSumSubArray(new int[]{-3, 2, 3, 1, 6}));
    }

    private static boolean findZeroSumSubArray(int[] numbers){
        Set<Integer> set = new HashSet<>();
        int totalSum = 0;
        for (int index = 0; index < numbers.length; index++) {
            totalSum = totalSum + numbers[index];
            if(set.contains(totalSum)){
                return true;
            }
            set.add(totalSum);
        }
        return false;
    }
}
