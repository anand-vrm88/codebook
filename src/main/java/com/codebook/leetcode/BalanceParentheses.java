package com.codebook.leetcode;

public class BalanceParentheses {

    public static void main(String[] args) {
        System.out.println(balanceParentheses("(a)b(c)d(e)f)(g)"));
    }

    private static String balanceParentheses(String str) {
        int balanceTracker = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                balanceTracker++;
            } else if (ch == ')') {
                balanceTracker--;
            }

            if (balanceTracker < 0) {
                balanceTracker = 0;
                continue;
            }

            sb.append(ch);
        }

        if (balanceTracker > 0) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == '(' && balanceTracker > 0) {
                    sb.deleteCharAt(i);
                    balanceTracker--;
                }
            }
        }

        return sb.toString();
    }
}

