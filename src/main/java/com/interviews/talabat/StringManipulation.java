package com.interviews.talabat;

/**
 * In this task you have to create all permutations of an input string and remove duplicates, if present.
 * This means, you have to shuffle all letters from the input in all possible orders.
 * <p>
 * Examples:
 * <p>
 * permutations('a'); // ['a']
 * permutations('abc'); // ['abc', 'acb', 'bac', 'bca', 'cab', 'cba']
 * permutations('abcd'); // ['abcd', 'abdc', ...]
 * The order of the permutations doesn't matter.
 */

public class StringManipulation {

    public static void main(String[] args) {
        String inputString = "abcde";
        permutation("", inputString);
    }

    // "", abc
    // a, bc
    // ab, c
    static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0) {
            System.out.println(prefix);

        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }
}
