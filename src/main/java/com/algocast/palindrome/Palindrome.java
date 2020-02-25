package com.algocast.palindrome;

import static java.util.Objects.nonNull;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(palindrome("abcdba"));
    }

    static boolean palindrome(String str) {
        boolean isPalindrome = true;

        if (nonNull(str) && str.length() > 1) {
            for (int i = str.length() - 1, j = 0; i >= str.length() / 2 && j <= str.length() / 2; i--, j++) {
                if (str.charAt(i) != str.charAt(j)) {
                    isPalindrome = false;
                    break;
                }
            }
        }

        return isPalindrome;
    }
}
