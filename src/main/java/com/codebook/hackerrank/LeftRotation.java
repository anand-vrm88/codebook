package com.codebook.hackerrank;

public class LeftRotation {

    static int[] rotLeft(int[] a, int d) {
        int[] result = new int[a.length];
        int absRotation = d % a.length;
        for(int i = 0; i < a.length; i++){
            int rotation = i - absRotation;
            if(rotation < 0){
                rotation = a.length + rotation;
            }
            result[rotation]=a[i];
        }
        return result;
    }
}
