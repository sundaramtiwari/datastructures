package com.interviews.getyourguide;

import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<String> inputList = Arrays.asList("interface", "intersect", "interlocate", "interfere");
        System.out.println(getLongestPrefix(inputList));
    }

    private static String getLongestPrefix(List<String> inputList) {
        String baseString = inputList.get(0);
        char[] inputArray = baseString.toCharArray();
        StringBuilder commonPrefix = new StringBuilder();

        for (int i = 0; i < inputArray.length; i++) {
            char ch = inputArray[i];

            for (int j = 1; j < inputList.size(); j++) {
                String currentString = inputList.get(j);
                char curChar = currentString.charAt(i);

                if (!(ch == curChar)) {
                    return commonPrefix.toString();
                }
            }

            commonPrefix.append(ch);
        }

        return commonPrefix.toString();
    }
}
