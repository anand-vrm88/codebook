package com.codebook.misc.connection;

import com.codebook.misc.connection.api.Connection;
import com.codebook.misc.connection.api.ConnectionPoolManager;
import com.codebook.misc.connection.impl.DefaultConnectionPoolManager;
import com.codebook.misc.connection.impl.DefaultConnectionProvider;

import java.util.Objects;

public class ConnectionPoolManagerDemo {

    public static void main(String[] args) {
        ConnectionPoolManager connectionPoolManager = new DefaultConnectionPoolManager(
                5, new DefaultConnectionProvider()
        );

        for (int index = 0; index < 50; index++) {
            new Thread(new WorkerThread(connectionPoolManager)).start();
        }
    }
}

class WorkerThread implements Runnable {

    private final ConnectionPoolManager connectionPoolManager;

    public WorkerThread(ConnectionPoolManager connectionPoolManager) {
        this.connectionPoolManager = connectionPoolManager;
    }

    @Override
    public void run() {
        Connection connection = this.connectionPoolManager.getConnection();
        if(!Objects.isNull(connection)) {
            connection.execute();
        }
        this.connectionPoolManager.releaseConnection(connection);
    }
}
