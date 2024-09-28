package com.codebook.study.parser;

import javax.swing.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ExpressionParser {

    private static int index;

    private static final Set<Character> constants = new HashSet<>(
            Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
    );

    private static final Set<Character> binaryOperators = new HashSet<>(
            Arrays.asList('+', '-', '*', '/')
    );

    public static Expression build(String expression, Composite composite, int index) {
        char ch = expression.charAt(index);
        if (constants.contains(ch)) {

        }
        return null;
    }
}
