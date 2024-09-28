package com.codebook.study.parser;

abstract public class Composite implements Visitable {

    private Expression left;
    private Expression right;

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }
}
