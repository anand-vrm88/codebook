package com.codebook.insta;

import java.util.Arrays;
import java.util.OptionalInt;

public class Problem3 {

    private static String challengeToken(String[] strArray) {
        String N = strArray[0];
        String K = strArray[1];
        StringBuilder result = new StringBuilder(N);
        for (int index = 0; index < N.length(); index++) {
            StringBuilder localResult = new StringBuilder();
            int[] charFrequencyInK = buildCharFrequency(K);
            for (int secondIndex = index; secondIndex < N.length(); secondIndex++) {
                if(areAllCharsConsidered(charFrequencyInK)){
                    if(localResult.length() > 0 && result.length() > localResult.length()){
                        result = localResult;
                        break;
                    }
                }
                char ch = N.charAt(secondIndex);
                if (charFrequencyInK[ch - 'a'] > 0) {
                    charFrequencyInK[ch - 'a'] -= 1;
                }
                localResult.append(ch);
            }
        }
        return result.toString();
    }

    private static boolean areAllCharsConsidered(int[] chars){
        OptionalInt optionalInt = Arrays.stream(chars).reduce(
                Integer::sum
        );

        return optionalInt.isPresent() && 0 == optionalInt.getAsInt();
    }

    private static int[] buildCharFrequency(String str){
        int[] charFrequency = new int[26];
        for (int index = 0; index < str.length(); index++) {
            charFrequency[str.charAt(index) - 'a'] += 1;
        }

        return charFrequency;
    }

    public static void main(String[] args) {
        System.out.println(challengeToken(new String[]{"ahffaksfajeeubsne", "jefaa"}));
        System.out.println(challengeToken(new String[]{"aaffhkksemckelloe", "fhea"}));
    }
}
