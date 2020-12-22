package com.codebook.leetcode;

import java.util.Arrays;
import java.util.List;

public class AlienDictionary {

    public static void main(String[] args) {


    }

    public boolean isAlienSorted(String[] words, String order) {
        int[] langOrder = new int[26];
        List<String> stringList = Arrays.asList(words);
        int orderIndex = 0;
        for(Character ch : order.toCharArray()){
            langOrder[ch - 'a'] = orderIndex++;
        }

        return false;
    }
}
