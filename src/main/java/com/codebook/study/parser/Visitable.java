package com.codebook.study.parser;

public interface Visitable {
    void accept(Visitor visitor);
}
