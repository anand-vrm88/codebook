package com.codebook.misc;

import java.util.function.Function;

public class LambdaPractice {

    public static void main(String[] args) {
        String myString = "Hello";
        Function<String, String> function = text -> myString + text;
        System.out.println(function.apply("Hey"));

    }
}
