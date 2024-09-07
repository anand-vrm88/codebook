package com.codebook.study;

public class WaitNotifyDemo {

    public static void main(String[] args) throws InterruptedException {
        WaitNotifyDemo monitor = new WaitNotifyDemo();

        Worker1 worker1 = new Worker1(monitor);
        worker1.start();
        Worker2 worker2 = new Worker2(monitor);
        worker2.start();
        Worker3 worker3 = new Worker3(monitor);
        worker3.start();
        Leader leader = new Leader(monitor);
        leader.start();

        worker1.join();
        worker2.join();
        worker3.join();
        leader.join();
    }
}

class Worker1 extends Thread {
    final WaitNotifyDemo monitor;

    public Worker1(WaitNotifyDemo monitor) {
        super("Worker1");
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Waiting in %s\n", this.getName());
            synchronized (monitor) {
                this.monitor.wait();
            }
            System.out.printf("Completing in %s\n", this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }
}

class Worker2 extends Thread {

    final WaitNotifyDemo monitor;

    public Worker2(WaitNotifyDemo monitor) {
        super("Worker2");
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Waiting in %s\n", this.getName());
            synchronized (monitor) {
                this.monitor.wait();
            }
            System.out.printf("Completing in %s\n", this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }
}

class Worker3 extends Thread {

    final WaitNotifyDemo monitor;

    public Worker3(WaitNotifyDemo monitor) {
        super("Worker3");
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            System.out.printf("Waiting in %s\n", this.getName());
            synchronized (monitor) {
                this.monitor.wait();
            }
            System.out.printf("Completing in %s\n", this.getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        super.run();
    }
}

class Leader extends Thread {
    final WaitNotifyDemo monitor;

    public Leader(WaitNotifyDemo monitor) {
        super("Leader");
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.printf("Waiting to notify in %s\n", this.getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (monitor) {
            this.monitor.notifyAll();
        }
        System.out.printf("Notified in %s\n", this.getName());
        super.run();
    }
}