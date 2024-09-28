package com.codebook.interview;

public class DeletionToSmallestNumber {

    public static void main(String[] args) {
        System.out.println(findSmallestNumber("1432219", 3));
    }

    private static String findSmallestNumber(String number, int k) {
        return findSmallestNumber(number, k, 0, new StringBuilder()).toString();
    }

    private static Long findSmallestNumber(String number, int k, int index, StringBuilder result){
        if(k == 0){
            return Long.parseLong(result.toString());
        }

        if(index >= number.length()){
            return Long.parseLong(result.toString());
        }

        return Math.min(
                findSmallestNumber(number, k, index + 1, new StringBuilder(result)),
                findSmallestNumber(number, k - 1, index + 1, new StringBuilder(result.append(number.charAt(index))))
        );
    }
}
