package com.codebook.daily;

import java.util.Objects;

public class MaximizeStockProfit {

    public static void main(String[] args) {
        System.out.println(maximizeProfit(new int[] {1, 2, 3, 4, 5}));
    }

    private static int maximizeProfit(int[] stockPrices) {
        return Math.max(
                maximizeProfit(stockPrices, 1, stockPrices[0]),
                maximizeProfit(stockPrices, 1, null)
        );
    }

    private static int maximizeProfit(int[] stockPrices, int chronologicalIndex, Integer lastBoughtPrice) {
        if (chronologicalIndex == stockPrices.length - 1) {
            return Objects.isNull(lastBoughtPrice) ? 0 : (stockPrices[chronologicalIndex] - lastBoughtPrice);
        }

        if (Objects.isNull(lastBoughtPrice)) {
            return Math.max(
                    maximizeProfit(stockPrices, chronologicalIndex + 1, stockPrices[chronologicalIndex]),
                    maximizeProfit(stockPrices, chronologicalIndex + 1, null)
            );
        } else {
            int localProfitIfSelling = stockPrices[chronologicalIndex] - lastBoughtPrice;
            localProfitIfSelling += maximizeProfit(stockPrices, chronologicalIndex + 1, null);

            int localProfitInNotSelling = maximizeProfit(stockPrices, chronologicalIndex + 1, lastBoughtPrice);

            return Math.max(localProfitIfSelling, localProfitInNotSelling);
        }
    }
}
