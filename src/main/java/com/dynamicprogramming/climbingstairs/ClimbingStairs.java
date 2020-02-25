package com.dynamicprogramming.climbingstairs;

import java.util.ArrayList;
import java.util.List;

/**
 * You can climb 1 or 2 stairs with one step. How many different ways can you climb n stairs?
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println(climbStairsIterative(4));
    }

    /**
     * Recursive solution that run's in exponential time.
     * Could optimize using a cache.
     *
     * @param stairs
     * @return ways can you climb n stairs
     */
    public static long climbStairsRecursive(int stairs) {
        if (stairs == 1) {
            return 1;
        }
        if (stairs == 2) {
            return 2;
        }

        return climbStairsRecursive(stairs - 1) + climbStairsRecursive(stairs - 2);
    }

    /**
     * Iterative solution that runs in O(n) time
     *
     * @param stairs
     * @return ways can you climb n stairs
     */
    public static long climbStairsIterative(int stairs) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);

        for (int i = 2; i < stairs; i++) {
            list.add(list.get(i - 1) + list.get(i - 2));
        }

        return list.get(stairs - 1);
    }
}
