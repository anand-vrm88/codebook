package com.codebook.daily;

import java.util.List;
import java.util.function.Function;

public class NumberOfWayToStepStair implements Function<Integer, Integer> {

    private final List<Integer> allowedSteps;

    public NumberOfWayToStepStair(List<Integer> allowedSteps) {
        this.allowedSteps = allowedSteps;
    }

    @Override
    public Integer apply(Integer totalNumberOfSteps) {
        if (totalNumberOfSteps == 0) {
            return 1;
        } else if (totalNumberOfSteps < 0){
            return 0;
        }

        int uniqueWays = 0;
        for (Integer allowedStep : allowedSteps) {
            uniqueWays += apply(totalNumberOfSteps - allowedStep);
        }
        return uniqueWays;
    }
}
