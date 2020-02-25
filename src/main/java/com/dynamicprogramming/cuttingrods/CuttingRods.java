package com.dynamicprogramming.cuttingrods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a rod of length n and prices P[i] for i=1,2,3...,n, where P[i] is
 * the price of a rod of length i. Find the maximum total revenue you can
 * make by cutting and selling the rod (assume no cost for cutting the rod).
 */
public class CuttingRods {

    public static void main(String[] args) {
        System.out.println(revenueIterativeNew(4, Arrays.asList(1, 5, 8, 9, 11)));
    }

    /**
     * Takes time O(n2) = O(n) * (Om/2).
     *
     * @param length
     * @param priceList
     * @return
     */
    public static int revenueIterativeNew(int length, List<Integer> priceList) {
        List<Integer> revenueList = new ArrayList<>(priceList.size());
        revenueList.add(0, priceList.get(0));

        for (int i = 1; i < priceList.size(); i++) {
            int curMax = priceList.get(i);
            for (int j = 0; j <= i / 2; j++) {
                int tempMax = revenueList.get(j) + revenueList.get(i - j - 1);
                curMax = Math.max(curMax, tempMax);
            }
            revenueList.add(i, curMax);
        }

        return revenueList.get(length - 1);
    }

    /**
     * Takes O(n2) time = O(n) * O(m)
     *
     * @param size
     * @param priceList
     * @return
     */
    public static int revenueIterative(int size, List<Integer> priceList) {

        List<Integer> revenueList = new ArrayList<>();
        revenueList.add(0, 0);

        for (int i = 1; i <= size; i++) {
            int maxVal = -1;
            for (int j = 1; j <= i; j++) {
                int temp = priceList.get(j - 1) + revenueList.get(i - j);
                if (temp > maxVal) {
                    maxVal = temp;
                }
            }
            revenueList.add(i, maxVal);
        }
        return revenueList.get(size);
    }

    /**
     * Recursive solution running in exponential time.
     *
     * @param size
     * @param priceList
     * @return
     */
    public static int revenueRecursive(int size, List<Integer> priceList) {
        if (size == 0) {
            return 0;
        }
        int maxVal = -1;

        for (int i = 0; i < size; i++) {
            Integer currentPrice = priceList.get(size - i - 1);
            int revenueRecursive = revenueRecursive(i, priceList);
            int temp = currentPrice + revenueRecursive;
            if (temp > maxVal) {
                maxVal = temp;
            }
        }

        return maxVal;
    }
}
