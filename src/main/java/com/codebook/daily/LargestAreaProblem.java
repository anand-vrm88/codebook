package com.codebook.daily;

public class LargestAreaProblem {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 1, 0, 0},
                {1, 1, 1, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 0}
        };

        System.out.println(calculateLargestArea(matrix));
    }

    private static int calculateLargestArea(int[][] matrix) {
        int maxArea = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) {
                int area = calculateLargestArea(matrix, rowIndex, columnIndex);
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    private static int calculateLargestArea(int[][] matrix, int rowStartIndex, int columnStartIndex){
        return calculateLargestArea(matrix, rowStartIndex, columnStartIndex, 0, 0);
    }

    private static int calculateLargestArea(int[][] matrix, int rowStartIndex, int columnStartIndex, int rowOffSet, int columnOffset){
        if ((rowStartIndex + rowOffSet) >= matrix.length || (columnStartIndex + columnOffset) >= matrix[0].length) {
            return 0;
        }

        int areaWithCurrentDimension = calculateArea(matrix, rowStartIndex, columnStartIndex, rowOffSet, columnOffset);
        int areaWithExtraRow = calculateLargestArea(matrix, rowStartIndex, columnStartIndex, rowOffSet + 1, columnOffset);
        int areaWithExtraColumn = calculateLargestArea(matrix, rowStartIndex, columnStartIndex, rowOffSet, columnOffset + 1);

        return max(areaWithCurrentDimension, areaWithExtraRow, areaWithExtraColumn);
    }

    private static int max(int num1, int num2, int num3) {
        return Math.max(Math.max(num1, num2), num3);
    }

    private static int calculateArea(int[][] matrix, int rowStartIndex, int columnStartIndex, int rowOffSet, int columnOffset) {
        for (int rowIndex = rowStartIndex; rowIndex <= rowOffSet; rowIndex++) {
            for (int columnIndex = columnStartIndex; columnIndex <= columnOffset; columnIndex++) {
                if (matrix[rowIndex][columnIndex] != 1) {
                    return 0;
                }
            }
        }
        return (columnOffset - columnStartIndex + 1) * (rowOffSet - rowStartIndex + 1);
    }
}
