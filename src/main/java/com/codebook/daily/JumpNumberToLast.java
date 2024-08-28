package com.codebook.daily;

public class JumpNumberToLast {

    boolean canReach(int[] numbers, int size, int currIndex) {
        if (currIndex == size - 1) {
            return true;
        } else if (currIndex >= size) {
            return false;
        } else if (numbers[currIndex] == 0) {
            return false;
        } else {
            for (int index = currIndex + 1; index <= currIndex + numbers[currIndex]; index++) {
                if (canReach(numbers, size, index)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        //int[] numbers = new int[]{2, 0, 1, 0};
        int[] numbers = new int[]{16, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0};
        System.out.println(new JumpNumberToLast().canReach(numbers, numbers.length, 0));
    }
}
