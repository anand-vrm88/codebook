package com.codebook.daily;


//O(2^(row + column))
public class CoinCollection {

    private static int maximiseCoinCollection(int[][] matrix, int row, int column) {
        if (row >= matrix.length || column >= matrix[0].length) {
            return 0;
        }

        if ((row == matrix.length - 1) && (column == matrix[0].length - 1)) {
            return matrix[row][column];
        }

        return Math.max(
                matrix[row][column] + maximiseCoinCollection(matrix, row, column + 1),
                matrix[row][column] + maximiseCoinCollection(matrix, row + 1, column)
        );
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 3, 1, 1},
                {2, 0, 0, 4},
                {1, 5, 3, 1}
        };

        System.out.println(maximiseCoinCollection(matrix, 0, 0));
    }
}
