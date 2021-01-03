package com.codebook.leetcode;

public class SearchMatrix {

    public static void main(String[] args) {
        //int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(matrix, 20));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (matrix[0][mid] == target) {
                return true;
            } else if (matrix[0][mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        int column = right;
        int top = 0;
        int bottom = matrix.length - 1;
        while(top <= bottom){
            int mid = (top + bottom) / 2;
            if (matrix[mid][column] == target) {
                return true;
            } else if (matrix[mid][column] > target) {
                bottom = mid - 1;
            } else {
                top = mid + 1;
            }
        }

        return false;
    }
}
