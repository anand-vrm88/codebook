package com.codebook.study;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerAndConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        MessageQueue messageQueue = new MessageQueue(1);

        Producer producer1 = new Producer("Producer-1", messageQueue);
        Producer producer2 = new Producer("Producer-2", messageQueue);
        Producer producer3 = new Producer("Producer-3", messageQueue);
        Producer producer4 = new Producer("Producer-4", messageQueue);

        Consumer consumer1 = new Consumer("Consumer-1", messageQueue);
        //Consumer consumer2 = new Consumer("Consumer-2", messageQueue);

        producer1.start();
        producer2.start();
        producer3.start();
        producer4.start();

        consumer1.start();
        //consumer2.start();

        producer1.join();
        producer2.join();
        producer3.join();
        producer4.join();
        consumer1.join();
        //consumer2.join();
    }
}

class Producer extends Thread {

    final MessageQueue messageQueue;

    public Producer(String producerName, MessageQueue messageQueue) {
        super(producerName);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        int messageCounter = 0;
        while (true) {
            String message = String.format("Message{%s:%s}", Thread.currentThread().getId(), messageCounter);
            messageQueue.write(message);
            System.out.printf("%s is writing message = %s\n", Thread.currentThread().getName(), message);
            messageCounter++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Consumer extends Thread {

    final MessageQueue messageQueue;

    public Consumer(String consumerName, MessageQueue messageQueue) {
        super(consumerName);
        this.messageQueue = messageQueue;
    }

    @Override
    public void run() {
        while (true) {
            String message = messageQueue.read();
            System.out.printf("%s is reading message = %s\n", Thread.currentThread().getName(), message);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MessageQueue {
    private final Queue<String> queue = new LinkedList<>();
    private final int capacity;
    private volatile int size;

    //final Object messageQueueMonitor = new Object();
    final Object writerMonitor = new Object();
    final Object readerMonitor = new Object();

    public MessageQueue(int capacity) {
        this.capacity = capacity;
    }

    public void write(String message){
        synchronized (writerMonitor) {
            if (size >= capacity) {
                try {
                    String producerName = Thread.currentThread().getName();
                    System.out.printf("%s is waiting --- (Message queue is full)\n", producerName);
                    writerMonitor.wait();
                    System.out.printf("%s is notified by consumer thread to write new message.\n", producerName);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(message);
            size++;
        }

        synchronized (readerMonitor) {
            readerMonitor.notifyAll();
        }
    }

    public String read(){
        String message;
        synchronized (readerMonitor) {
            if (size <= 0) {
                try {
                    String consumerName = Thread.currentThread().getName();
                    System.out.printf("%s is waiting --- (Message queue is empty)\n", consumerName);
                    readerMonitor.wait();
                    System.out.printf("%s notified by producer thread to read new message.\n", consumerName);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            message = queue.poll();
            size--;
        }

        synchronized (writerMonitor) {
            writerMonitor.notifyAll();
        }
        return message;
    }
}
