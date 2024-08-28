package com.codebook.misc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TripletSum {

    public static void main(String[] args) {
        int[] numbers = {-1, 0, 1, 2, -1, -4};
        generateTripletSum(numbers, 0);
    }

    private static void generateTripletSum(int[] numbers, int targetSum) {
        for (int index = 0; index < numbers.length - 2; index++) {
            List<List<Integer>> results = generateTwoSum(numbers, targetSum - numbers[index], index + 1);
            if(!results.isEmpty()){
                for(List<Integer> result: results){
                    result.add(0, numbers[index]);
                    System.out.println(result);
                }
            }
        }
    }

    private static List<List<Integer>> generateTwoSum(int[] numbers, int targetSum, int startIndex){
        List<List<Integer>> results = new LinkedList<>();

        Set<Integer> set = new HashSet<>();

        for (int index = startIndex; index < numbers.length; index++) {
            if (set.contains(targetSum - numbers[index])) {
                List<Integer> result = new LinkedList<>();
                result.add(targetSum - numbers[index]);
                result.add(numbers[index]);
                results.add(result);
            }
            set.add(numbers[index]);
        }

        return results;
    }

}
