package com.codebook.daily;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class NonUniformNumberGenerator {

    private static final int PROBABILITY_SPACE_LIMIT = 10000;

    private final int[] numberSet;
    private final Random random;
    private final int[] probabilitiesSpace;

    public NonUniformNumberGenerator(int[] numberSet, float[] probabilities) {
        this.numberSet = numberSet;
        this.random = new Random();
        this.probabilitiesSpace = new int[PROBABILITY_SPACE_LIMIT];

        int offset = -1;
        for (int index = 0; index < numberSet.length; index++) {
            float probability = probabilities[index];
            int probabilitySpace = new Float(probability * PROBABILITY_SPACE_LIMIT).intValue();
            buildProbabilitySpace(probabilitiesSpace, index, offset + 1, offset + probabilitySpace);
            offset = offset + probabilitySpace;
        }
    }

    public void buildProbabilitySpace(int[] probabilitiesSpace, int numberSetIndex, int startIndex, int endIndex) {
        for (int index = startIndex; index <= endIndex; index++) {
            probabilitiesSpace[index] = numberSetIndex;
        }
    }

    public static void main(String[] args) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        NonUniformNumberGenerator nonUniformNumberGenerator = new NonUniformNumberGenerator(
                new int[]{1, 2, 3, 4},
                new float[]{0.1f, 0.5f, 0.2f, 0.2f}
        );

        for (int index = 0; index < 10000; index++) {
            int number = nonUniformNumberGenerator.generateNumber();
            Integer frequency = frequencyCount.getOrDefault(number, 0);
            frequency++;
            frequencyCount.put(number, frequency);
        }

        Map<Integer, Float> percentageMap = new HashMap<>();
        for(Integer key : frequencyCount.keySet()){
            Integer frequency = frequencyCount.get(key);
            percentageMap.put(key, frequency.floatValue()/PROBABILITY_SPACE_LIMIT);
        }
        System.out.println(percentageMap);
    }

    public int generateNumber(){
        int nextInt = this.random.nextInt(10000);
        int numberIndex = this.probabilitiesSpace[nextInt];
        return numberSet[numberIndex];
    }
}
