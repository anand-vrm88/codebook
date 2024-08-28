package com.codebook.misc;

//Maximum price.
//Array of user defined objects provided by client
//Each user defined object contains way to calculate its score.

import java.util.ArrayList;
import java.util.List;

public class MaximumSumOfArray {
    public static void main(String[] args) {
        int[] numbers = new int[]{6, 5, 5, 7, 4};
        System.out.println(new MaximumSumOfArray().maximumSum(numbers));

/*        Priceable[] items = new Priceable[]
                {
                        new Car(650000),
                        new Refrigerator(35000),
                        new Sofa(12500),
                        new Refrigerator(7000),
                        new Car(2200000),
                        new Sofa(45500),
                };*/

        House[] houses = new House[]
                {
                        House.builder().item(new Car(700000)).item(new Sofa(5000)).build(),
                        House.builder().item(new Car(1000000)).item(new Sofa(8000)).item(new Refrigerator(15000)).build(),
                        House.builder().item(new Car(1000000)).item(new Refrigerator(15000)).build(),
                        House.builder().item(new Sofa(40000)).item(new Refrigerator(15000)).build(),
                        House.builder().item(new Car(300000)).item(new Car(1100000)).build(),
                };
        System.out.println(new MaximumSumOfArray().maximumProfit(houses));
    }

    private int maximumProfit(Priceable[] items) {
        int arraySize = items.length;
        if (arraySize <= 1) {
            return items[0].getPrice();
        }

        int startIndex = 0;
        int[] maximumSum = new int[arraySize];
        for (int index = startIndex; index < arraySize; index++) {
            maximumSum[index] = -1;
        }
        return Math.max(
                items[startIndex].getPrice() + maximumProfit(items, startIndex + 2, arraySize, maximumSum),
                maximumProfit(items, startIndex + 1, arraySize, maximumSum)
        );
    }

    private int maximumProfit(Priceable[] items, int index, int size, int[] maximumSum){
        if(index >= size){
            return 0;
        }

        if(maximumSum[index] != -1){
            return maximumSum[index];
        }

        maximumSum[index] = Math.max(
                items[index].getPrice() + maximumProfit(items, index + 2, size, maximumSum),
                maximumProfit(items, index + 1, size, maximumSum)
        );

        return maximumSum[index];
    }

    private int maximumSum(int[] numbers) {
        int arraySize = numbers.length;
        if (arraySize <= 1) {
            return numbers[0];
        }

        int startIndex = 0;
        int[] maximumSum = new int[arraySize];
        for (int index = startIndex; index < arraySize; index++) {
            maximumSum[index] = -1;
        }
        return Math.max(
                numbers[startIndex] + maximumSum(numbers, startIndex + 2, arraySize, maximumSum),
                maximumSum(numbers, startIndex + 1, arraySize, maximumSum)
        );
    }

    private int maximumSum(int[] numbers, int index, int size, int[] maximumSum){
        if(index >= size){
            return 0;
        }

        if(maximumSum[index] != -1){
            return maximumSum[index];
        }

        maximumSum[index] = Math.max(
                numbers[index] + maximumSum(numbers, index + 2, size, maximumSum),
                maximumSum(numbers, index + 1, size, maximumSum)
        );

        return maximumSum[index];
    }
}

interface Priceable {
    Integer getPrice();
}

class Car implements Priceable {

    private final Integer price;

    public Car(Integer price) {
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }
}

class Refrigerator implements Priceable {

    final private Integer price;

    public Refrigerator(Integer price) {
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }
}

class Sofa implements Priceable {
    final private Integer price;

    public Sofa(Integer price) {
        this.price = price;
    }

    @Override
    public Integer getPrice() {
        return this.price;
    }
}

class House implements Priceable {

    private final List<Priceable> items;

    private House(HouseBuilder builder){
        this.items = builder.items;
    }

    public static HouseBuilder builder() {
        return new HouseBuilder();
    }

    @Override
    public Integer getPrice() {
        return this.items.stream().mapToInt(Priceable::getPrice).sum();
    }

    static class HouseBuilder {
        private final List<Priceable> items;

        HouseBuilder() {
            this.items = new ArrayList<>();
        }

        HouseBuilder item(Priceable item){
            this.items.add(item);
            return this;
        }

        House build(){
            return new House(this);
        }
    }
}
