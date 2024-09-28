package com.codebook.daily;

import java.util.Stack;


//O(2^sqrt(n))
public class SquaredSum {

    public static void main(String[] args) {
        System.out.println(findSmallestNumberOfSquaredSum(12));
    }

    private static int findSmallestNumberOfSquaredSum(int n) {
        Stack<Integer> stack = new Stack<>();
        if (findSmallestNumberOfSquaredSum(n, new Double(Math.floor(Math.sqrt(Integer.valueOf(n).doubleValue()))).intValue(), 0, stack)) {
            System.out.println("numbers = " + stack);
            Integer sum = stack.stream().map(x -> x * x).reduce(0, Integer::sum);
            System.out.println("Sum = " + sum);
            return stack.size();
        } else {
            System.out.println("Sorry! No combination found");
            return -1;
        }
    }

    private static boolean findSmallestNumberOfSquaredSum(int n, int squaringNumber, int sum, Stack<Integer> stack){
        if (squaringNumber <= 1) {
            return false;
        }

        if (sum == n) {
            return true;
        }

        if (sum > n){
            return false;
        }

        stack.add(squaringNumber);
        if(findSmallestNumberOfSquaredSum(n, squaringNumber, sum + (squaringNumber*squaringNumber), stack)){
            return true;
        }
        stack.pop();

        return findSmallestNumberOfSquaredSum(n, squaringNumber - 1, sum, stack);
    }
}
