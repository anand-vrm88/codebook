package com.codebook.study;

public class LockDemo {
    private static int count;

    public static void main(String[] args) {
        LockDemo lockDemo = new LockDemo();

        Runnable runnable = () -> {
            System.out.printf("Thread %s is waiting on instance lock...\n", Thread.currentThread().getId());
            //System.out.printf("Thread %s is waiting on class lock...\n", Thread.currentThread().getId());
            synchronized (lockDemo) {
                //System.out.printf("Thread %s is waiting on instance lock...\n", Thread.currentThread().getId());
                System.out.printf("Thread %s is waiting on class lock...\n", Thread.currentThread().getId());
                synchronized (LockDemo.class) {
                    System.out.printf("Thread %s is running...\n", Thread.currentThread().getId());
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    for (int index = 0; index < 1000; index++) {
                        count++;
                    }
                    System.out.printf("Thread %s is completed\n", Thread.currentThread().getId());
                }
            }
        };

/*        for (int index = 0; index < 3; index++) {
            new Thread(runnable).start();
        }*/

        for (int index = 0; index < 3; index++) {
            new MyRunnable().start();
        }
    }
}

class MyRunnable extends Thread {

    @Override
    public void run() {
        //System.out.printf("Thread %s is waiting on instance lock...\n", Thread.currentThread().getId());
        System.out.printf("Thread %s is waiting on class lock...\n", Thread.currentThread().getId());
        synchronized (LockDemo.class) {
        //synchronized (this) {
            System.out.printf("Thread %s is waiting on instance lock...\n", Thread.currentThread().getId());
            //System.out.printf("Thread %s is waiting on class lock...\n", Thread.currentThread().getId());
            //synchronized (LockDemo.class) {
                synchronized (this) {
                System.out.printf("Thread %s is running...\n", Thread.currentThread().getId());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.printf("Thread %s is completed\n", Thread.currentThread().getId());
            }
        }
    }
}
