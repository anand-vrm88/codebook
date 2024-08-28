package com.codebook.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class SpecialSingleton {

    private static final List<SpecialSingleton> instances = new ArrayList<>();
    private static final int instancesMaxCount = 20;
    private static int requestCount;

    static {
        for (int count = 0; count < instancesMaxCount; count++) {
            instances.add(new SpecialSingleton());
        }
    }

    private SpecialSingleton() {

    }

    public static SpecialSingleton getInstances() {
        if (instances.size() != instancesMaxCount) {
            throw new IllegalStateException("Insufficient instances initialized.");
        }

        synchronized (SpecialSingleton.class) {
            requestCount++;
            double random = Math.random() * 10000;
            return instances.get(Double.valueOf(random).intValue() % instancesMaxCount);
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int taskCount = 100000;
        int[] instanceCallDistribution = new int[instancesMaxCount];
        for(int index = 0; index < instancesMaxCount; index++){
            instanceCallDistribution[index] = 0;
        }
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Callable<Integer> callable = () -> SpecialSingleton.getInstances().hashCode();

        for (int index = 0; index < taskCount; index++) {
            Future<Integer> future = executorService.submit(callable);
            Integer hasCode = future.get();
            instanceCallDistribution[hasCode % instancesMaxCount] += 1;
        }

        for(int index =0 ; index < instanceCallDistribution.length; index ++){
            System.out.print(instanceCallDistribution[index] + " ");
        }
        //Stream.of(instanceCallDistribution).forEach(System.out::println);

/*        for (int index = 0; index < 100; index++) {
            Thread thread = new Thread(String.valueOf(index + 1)){
                @Override
                public void run() {
                    SpecialSingleton mySingletonInstance = SpecialSingleton.getInstances();
                    System.out.println(this.getName() + " : " + mySingletonInstance);
                }
            };
            thread.start();
        }*/
    }
}
