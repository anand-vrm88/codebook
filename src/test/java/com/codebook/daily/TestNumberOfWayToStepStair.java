package com.codebook.daily;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;


public class TestNumberOfWayToStepStair {

    Function<Integer, Integer> function = new NumberOfWayToStepStair(Arrays.asList(1, 2));

    @Test
    public void testStairsWithFourSteps(){
        Integer result = function.apply(4);
        Assert.assertEquals(5, result.intValue());
    }

    @Test
    public void testStairsWithTwoSteps(){
        Integer result = function.apply(2);
        Assert.assertEquals(2, result.intValue());
    }
}
