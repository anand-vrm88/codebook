package com.codebook.daily;

public class SquareRoot {

    public static final int ITERATION_LIMIT = 100000000;
    public static final float ERROR_MARGIN = 0.01f;
    public static final float PRECISION = 0.00001f;

    private static float findSquareRoot(float number){
        float result = 1.00f;
        for(int counter = 0; counter < ITERATION_LIMIT; counter++){
            if ((number - result * result) < ERROR_MARGIN) {
                return result;
            }
            result += counter * PRECISION;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(findSquareRoot(1000000000));
    }
}
