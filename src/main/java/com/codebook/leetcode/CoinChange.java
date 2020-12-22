package com.codebook.leetcode;

/*
                11
  10            9               6
9  8  5     8   7   4       5   4   1

 */

public class CoinChange {

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int sum = 11;
        int[] memory = new int[sum];

        for (int i = 0; i < sum; i++) {
            memory[i] = i;
        }

        System.out.println(coinChange(coins, sum, memory));
    }

    private static int coinChange(int[] coins, int sum, int[] memory) {
        if (sum < 0) {
            return -1;
        }

        for (int coin : coins) {
            if ((sum - coin) > 0) {
                memory[sum] = Math.min(1 + coinChange(coins, sum - coin, memory), memory[sum]);
            }
        }

        return memory[sum];
    }
}
