package com.dynamicprogramming.buyandsellstock;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Given price of a stock at different days.
 * Find out the max profit we could make if
 * we are allowed only one transaction.
 */
public class BuyAndSellStock {
    public static void main(String[] args) {
        System.out.println(maxGain(Arrays.asList(7,1,5,3,6,4)));
    }

    private static int maxGain(List<Integer> stockList) {
        if (Objects.isNull(stockList) || stockList.size() < 2)
            return 0;

        int curMin = stockList.get(0);
        int maxProfit = 0;

        // iterate through stock price list
        for (int i=1; i<stockList.size(); i++) {
            // if current stock price is greater than the current minimum stock price,
            // calculate gain and update maxProfit
            if (stockList.get(i) > curMin) {
                int gain = stockList.get(i) - curMin;
                if (gain > maxProfit)
                    maxProfit = gain;
            } else
                // else if current stock price is less than current minimum, update current minimum
                curMin = stockList.get(i);
        }

        return maxProfit;
    }

    private static int maxGainNSquare(List<Integer> stockList) {
        int maxProfit = 0;
        if (Objects.isNull(stockList) || stockList.size() < 2)
            return maxProfit;

        for (int i=0; i<stockList.size()-1; i++) {
            int buyPrice = stockList.get(i);

            for (int j=i+1; j<stockList.size(); j++) {
                int profit = stockList.get(j) - buyPrice;
                if (profit > maxProfit)
                    maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
