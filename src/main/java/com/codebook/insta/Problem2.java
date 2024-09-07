package com.codebook.insta;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Problem2 {

    public static String StringChallenge(String str) {
        // code goes here
        int maxUniqueChars = 0;

        Character pairChar = null;
        for(int index = 0; index < str.length(); index++){
            pairChar = str.charAt(index);
            Map<Character, Integer> charFrequency = new HashMap<>();
            for(int secondIndex = index + 1; secondIndex < str.length(); secondIndex++){
                if(str.charAt(secondIndex) == pairChar){
                    int uniqueCharsCount = calculateUniqueCharsCount(charFrequency);
                    if(maxUniqueChars < uniqueCharsCount){
                        maxUniqueChars = uniqueCharsCount;
                        break;
                    }
                }
                Integer orDefault = charFrequency.getOrDefault(str.charAt(secondIndex), 0);
                orDefault++;
                charFrequency.put(str.charAt(secondIndex), orDefault);
            }
        }
        return String.valueOf(maxUniqueChars);
    }

    private static int calculateUniqueCharsCount(Map<Character, Integer> charFrequency){
        int uniqueCharCount = 0;
        Iterator<Character> iterator = charFrequency.keySet().iterator();
        while (iterator.hasNext()) {
            if(charFrequency.get(iterator.next())  == 1){
                uniqueCharCount++;
            }
        }
        return uniqueCharCount;
    }

    public static void main (String[] args) {
        // keep this function call here
        //Scanner s = new Scanner(System.in);
        System.out.print(StringChallenge("mmmerme"));
    }
}
