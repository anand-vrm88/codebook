package com.codebook.misc.connection.impl;

import com.codebook.misc.connection.api.Connection;

public class DefaultConnection implements Connection {

    @Override
    public void execute() {

    }

    @Override
    public String toString() {
        return "DefaultConnection@"+hashCode();
    }
}
