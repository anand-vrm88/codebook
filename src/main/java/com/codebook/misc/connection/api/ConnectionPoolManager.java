package com.codebook.misc.connection.api;

public interface ConnectionPoolManager {
    Connection getConnection();

    void releaseConnection(Connection connection);
}
