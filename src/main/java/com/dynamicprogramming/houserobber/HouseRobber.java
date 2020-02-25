package com.dynamicprogramming.houserobber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are a professional robber planning to rob houses along a street.
 * Each house has a certain amount of money stashed, the only constraint
 * stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police
 * if two adjacent houses were broken into on the same night.
 * <p>
 * Given a list of non-negative integers representing the amount of money
 * of each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 */
public class HouseRobber {
    public static void main(String[] args) {
        System.out.println(maxGainOfRobbingIterative(Arrays.asList(3, 4, 15, 3, 9, 5, 6)));
    }

    private static int maxGainOfRobbingIterative(List<Integer> houseList) {
        List<Integer> gainList = new ArrayList<>(houseList.size());
        gainList.add(0, houseList.get(0));
        // Gain of second index is the max of robbing first house or the current second house:
        int gainOfSecondHouse = gainList.get(0) > houseList.get(1) ? gainList.get(0) : houseList.get(1);
        gainList.add(1, gainOfSecondHouse);

        for (int i = 2; i < houseList.size(); i++) {
            int gain = Math.max(gainList.get(i - 1), gainList.get(i - 2) + houseList.get(i));
            gainList.add(i, gain);
        }

        return gainList.get(gainList.size() - 1);
    }

    private static long maxGainOfRobbingRecursive(List<Integer> houseList) {
        long maxGain = 0l;

        for (int i = 0; i < houseList.size(); i++) {
            int gain = houseList.get(i);

            // scan right list for max gain
            long rightGain = i < houseList.size() - 2 ? maxGainOfRobbingRecursive(houseList.subList(i + 2, houseList.size())) : 0;

            // scan left list for max gain
            long leftGain = i > 1 ? maxGainOfRobbingRecursive(houseList.subList(0, i - 1)) : 0;

            long totalGain = gain + rightGain + leftGain;
            if (maxGain < totalGain) {
                maxGain = totalGain;
            }
        }

        return maxGain;
    }
}
