package com.codebook.daily;

import java.util.Stack;

public class SpecialBalanceParentheses {


    //O(3^n)
    public static void main(String[] args) {
        System.out.println(isParenthesesBalanced("*"));
    }

    private static boolean isParenthesesBalanced(String str){
        return isParenthesesBalanced(str, 0, new Stack<>());
    }

    private static boolean isParenthesesBalanced(String str, int index, Stack<Character> stack) {
        if (index >= str.length()) {
            return stack.isEmpty();
        }

        char ch = str.charAt(index);

        if (ch == '(') {
            stack.push(ch);
            return isParenthesesBalanced(str, index + 1, stack);
        } else if (ch == ')') {
            if (stack.isEmpty() || stack.peek() != '(') {
                return false;
            } else {
                stack.pop();
                return isParenthesesBalanced(str, index + 1, stack);
            }
        } else {
            Stack<Character> clonedStackForOpeningParentheses = new Stack<>();
            clonedStackForOpeningParentheses.addAll(stack);
            clonedStackForOpeningParentheses.push('(');

            Stack<Character> clonedStackForClosingParentheses = new Stack<>();
            clonedStackForClosingParentheses.addAll(stack);
            boolean isBalanced = true;
            if (clonedStackForClosingParentheses.isEmpty() || clonedStackForClosingParentheses.peek() != '(') {
                isBalanced = false;
            } else {
                clonedStackForClosingParentheses.pop();
            }

            return isParenthesesBalanced(str, index + 1, clonedStackForOpeningParentheses)
                    || (isBalanced && isParenthesesBalanced(str, index + 1, clonedStackForClosingParentheses))
                    || isParenthesesBalanced(str, index + 1, stack);
        }
    }
}
