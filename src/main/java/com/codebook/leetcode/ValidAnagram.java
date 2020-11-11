package com.codebook.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(isAnagram(s, t));
    }

    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            characterIntegerMap.put(key, characterIntegerMap.getOrDefault(key, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            characterIntegerMap.put(key, characterIntegerMap.getOrDefault(key, 0) - 1);
        }

        for (Map.Entry<Character, Integer> next : characterIntegerMap.entrySet()) {
            if (next.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
