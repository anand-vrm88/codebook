package com.codebook.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {
    Map<Character, Character> characterMap = new HashMap<>();

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String parenthesesPattern = "]";
        System.out.println(validParentheses.isValid(parenthesesPattern));
        System.out.println(validParentheses.isValidV2(parenthesesPattern));
    }

    public ValidParentheses() {
        characterMap.put('}', '{');
        characterMap.put(')', '(');
        characterMap.put(']', '[');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(ch);
                continue;
            }

            if (!characterMap.containsKey(ch)) {
                stack.push(ch);
            } else if (stack.peek().equals(characterMap.get(ch))) {
                stack.pop();
            } else{
                return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidV2(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(') {
                stack.push(ch);
            } else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            } else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            } else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
