package com.codebook.insta;

import java.util.Scanner;

public class Problem1 {

    public static String ArrayChallenge(String[] strArr) {
        // code goes here
        String[] extractedArray = strArr[0].replace("[", "").replace("]", "").split(",");
        String num1 = strArr[1].trim();
        String num2 = strArr[2].trim();

        int num1Index = getIndex(extractedArray, num1);
        int num2Index = getIndex(extractedArray, num2);

        if(num1Index == -1 || num2Index == -1){
            return null;
        }

        while(num1Index >= 0 || num2Index >= 0){
            if(num1Index == num2Index){
                return extractedArray[num1Index];
            } else if (num1Index < num2Index){
                num2Index = getParentIndex(num2Index);
            } else {
                num1Index = getParentIndex(num1Index);
            }
        }

        return extractedArray[0];
    }

    private static int getParentIndex(int index){
        if(index %2 == 0){
            return (index-2)/2;
        } else {
            return (index -1)/2;
        }

    }

    private static int getIndex(String[] array, String num){
        for(int index = 0; index < array.length; index++){
            if(array[index].trim().equalsIgnoreCase(num)){
                return index;
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        // keep this function call here
        Scanner s = new Scanner(System.in);
        System.out.print(ArrayChallenge(new String[]{"[5, 2, 6, 1, #, 8, #]", "2", "6"}));
    }
}
