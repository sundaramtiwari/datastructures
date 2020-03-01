package com.interviews.talabat;

/**
 * Create a function that returns the sum of the two lowest positive numbers given an array of minimum 4 positive integers.
 * No floats or non-positive integers will be passed.
 * <p>
 * For example, when an array is passed like [19, 5, 42, 2, 77], the output should be 7.
 * For example, when an array is passed like [6,5,4,3,2,1], the output should be 3.
 * For example, when an array is passed like [6,5,4,3,1,1], the output should be 2.
 */
public class SumOfMinTwo {
    public static void main(String[] args) {
        int[] input = {6, 5, 4, 3, 1, 1};

        System.out.println(min2Sum(input));
        // validate if array length is more than 4..
    }

    static int min2Sum(int[] input) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        // O(n)
        for (int i = 0; i < input.length; i++) {
            if (input[i] < min) {
                min2 = min;
                min = input[i];
            } else if (input[i] < min2) {
                min2 = input[i];
            }
        }

        return min + min2;
    }
}
