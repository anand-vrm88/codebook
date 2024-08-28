package com.codebook.daily;


import java.util.HashMap;
import java.util.Map;

/**
 * L is length of text.
 * N is max chars can be deleted.
 *
 * O(L^N)
 */
public class Palindrome {
    private static Map<String, Boolean> memory = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(canMakePalindrome("waterrndlqnwdlwndlwqdnqlwdnlfwnlkfqnlfqfetawx", 10));
    }

    private static boolean canMakePalindrome(String text, int charsToDelete) {
        if (memory.containsKey(text)) {
            return memory.get(text);
        }

        if (isPalindrome(text)) {
            memory.put(text, true);
            return true;
        }

        if (charsToDelete <= 0) {
            memory.put(text, false);
            return false;
        }

        for (int index = 0; index < text.length(); index++) {
            String updatedText = deleteCharAt(text, index);
            if (canMakePalindrome(updatedText, charsToDelete - 1)) {
                memory.put(text, true);
                return true;
            }
        }
        memory.put(text, false);
        return false;
    }

    private static boolean isPalindrome(String text){
        int startIndex = 0;
        int endIndex = text.length() - 1;

        while (startIndex < endIndex) {
            if (text.charAt(startIndex) != text.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }
        return true;
    }

    private static String deleteCharAt(String text, int index) {
        if (text.isEmpty() || index < 0 || text.length() <= index) {
            return text;
        }
        return text.substring(0, index) + text.substring(index + 1);
    }
}
