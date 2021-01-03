package com.codebook.leetcode;

public class NumOfWays {
    public static int numDecodings(String numbers) {
        if(numbers == null || numbers.length() == 0 || numbers.charAt(0) == '0'){
            return 0;
        }

        if(numbers.length() == 1){
            return 1;
        }
        int ways = 0;
        ways += numDecodings(numbers.substring(1, numbers.length()));
        int num = Integer.parseInt(numbers.substring(0, 2));
        if(num >= 0 && num <= 26){
            if(numbers.length() > 2){
                ways += numDecodings(numbers.substring(2, numbers.length()));
            }else {
                ways += 1;
            }
        }

        return ways;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("111111111111111111111111111111111111111111111"));
    }
}
