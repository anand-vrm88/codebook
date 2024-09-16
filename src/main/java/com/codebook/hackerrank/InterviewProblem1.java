package com.codebook.hackerrank;

public class InterviewProblem1 {
    public static void main(String[] args) {

        System.out.println(stepPerms(7));
    }

    public static int stepPerms(int n) {
        // Write your code here

        int[] mem = new int[n + 1];

        for(int index = 0; index <= n; index++){
            mem[index] = -1;
        }

        return stepPerms(n, mem);
    }

    private static int stepPerms(int n, int[] mem){
        if(n < 0){
            return 0;
        }

        if(mem[n] != -1){
            return mem[n];
        }

        if(n == 0){
            mem[n] = 1;
            return 1;
        }

        mem[n] = stepPerms(n - 1, mem) + stepPerms(n - 2, mem) + stepPerms(n - 3, mem);

        return mem[n];
    }
}
