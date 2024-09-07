package com.codebook.misc.connection.impl;

import com.codebook.misc.connection.api.Connection;
import com.codebook.misc.connection.api.ConnectionPoolManager;
import com.codebook.misc.connection.api.ConnectionProvider;

import java.util.LinkedList;
import java.util.List;

public class DefaultConnectionPoolManager implements ConnectionPoolManager {

    private final List<Connection> unusedConnections;
    private final List<Connection> usedConnections;

    public DefaultConnectionPoolManager(int size, ConnectionProvider connectionProvider) {
        unusedConnections = new LinkedList<>();
        usedConnections = new LinkedList<>();
        for (int index = 0; index < size; index++) {
            unusedConnections.add(connectionProvider.get());
        }
    }

    @Override
    public Connection getConnection() {
        if (!unusedConnections.isEmpty()) {
            Connection connection = unusedConnections.remove(0);
            usedConnections.add(connection);
            System.out.printf("Got %s \n", connection);
            return connection;
        }
        return null;
    }

    @Override
    public void releaseConnection(Connection connection) {
        if (usedConnections.remove(connection)) {
            System.out.printf("Released %s \n", connection);
            unusedConnections.add(connection);
        }
    }
}
