package com.codebook.misc;

import java.util.*;

public class RemoveDuplicate {

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 4, 2, 5, 3, 1, 4, 5};
        int[] deduplicatedNumbers = new RemoveDuplicate().deduplicateArray(numbers);
        System.out.println(Arrays.toString(deduplicatedNumbers));
    }

    private int[] deduplicateArray(int[] numbers) {
        if (Objects.isNull(numbers)) {
            throw new IllegalArgumentException("Numbers can't be null.");
        }

        if (numbers.length <= 1) {
            return numbers;
        }

        return method2(Arrays.copyOf(numbers, numbers.length));
    }

    private int[] method2(int[] numbers){
        Arrays.sort(numbers);

        int firstPointer = 0;
        int secondPointer = 1;

        for(; secondPointer < numbers.length; secondPointer++){
            if(numbers[firstPointer] != numbers[secondPointer]){
                firstPointer++;
                numbers[firstPointer] = numbers[secondPointer];
            }
        }

        firstPointer++;
        for(; firstPointer < numbers.length; firstPointer++){
            numbers[firstPointer] = -1;
        }

        return numbers;
    }

    private int[] method1(int[] numbers){
        Set<Integer> numberSet = new HashSet<>();
        int[] deduplicatedNumbers = new int[numbers.length];
        int index = 0;
        for(int number: numbers){
            if(!numberSet.contains(number)){
                deduplicatedNumbers[index++] = number;
                numberSet.add(number);
            }
        }
        return deduplicatedNumbers;
    }

    private int findSizeOfNewArray(int[] numbers){
        Arrays.sort(numbers);
        int size = 0;
        int visitedNumber = numbers[0];
        for (int currentNumber : numbers) {
            if (currentNumber != visitedNumber) {
                size++;
            }
            visitedNumber = currentNumber;
        }
        return size;
    }
}
