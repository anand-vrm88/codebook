package com.codebook.misc.connection.impl;

import com.codebook.misc.connection.api.Connection;
import com.codebook.misc.connection.api.ConnectionProvider;

public class DefaultConnectionProvider implements ConnectionProvider {

    @Override
    public Connection get() {
        return new DefaultConnection();
    }
}
