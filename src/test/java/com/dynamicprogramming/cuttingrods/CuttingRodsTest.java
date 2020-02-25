package com.dynamicprogramming.cuttingrods;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;

public class CuttingRodsTest {

    private static final List<Integer> PRICE_LIST = asList(1, 5, 8, 9, 11);

    @Test
    public void shouldPassForValidInput() {
        Assert.assertEquals(13, CuttingRods.revenueIterativeNew(5, PRICE_LIST));
    }

    @Test
    public void shouldPassForValidInput_1() {
        Assert.assertEquals(13, CuttingRods.revenueIterative(5, PRICE_LIST));
    }

    @Test
    public void shouldPassForValidInput_2() {
        Assert.assertEquals(13, CuttingRods.revenueRecursive(5, PRICE_LIST));
    }

}
