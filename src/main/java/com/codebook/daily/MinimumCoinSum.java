package com.codebook.daily;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MinimumCoinSum {

    public static void main(String[] args) {
        System.out.println(
                findMinimumCoinSum(
                        new HashSet<>(Arrays.asList(1, 5, 10, 25)),
                        5
                )
        );
    }

    static int findMinimumCoinSum(Set<Integer> denominations, int sum) {
        if (sum < 0) {
            return Integer.MAX_VALUE;
        }

        if (sum == 0) {
            return 0;
        }

        Set<Integer> remainingDenominations = new HashSet<>(denominations);
        int minimumCoins = Integer.MAX_VALUE;
        for (Integer denomination : denominations) {
            remainingDenominations.remove(denomination);
            int localMinCoins = findMinimumCoinSum(remainingDenominations, sum - denomination);
            if(localMinCoins < minimumCoins){
                minimumCoins = localMinCoins;
            }
        }
        return minimumCoins + 1;
    }
}
