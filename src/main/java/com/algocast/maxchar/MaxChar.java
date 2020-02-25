package com.algocast.maxchar;

import java.util.HashMap;
import java.util.Map;

public class MaxChar {

    public static void main(String[] args) {
        System.out.println(maxchar("abaadca 23 111"));
    }

    public static char maxchar(String s) {
        char character = 0;

        Map<Character, Integer> frequencyMap = new HashMap<>();

        char[] strArr = s.toCharArray();
        for (int i = 0; i < strArr.length; i++) {
            if (frequencyMap.containsKey(strArr[i])) {
                frequencyMap.put(strArr[i], frequencyMap.get(strArr[i]) + 1);
            } else {
                frequencyMap.put(strArr[i], 1);
            }
        }

        char maxChar = 0;
        int maxFreq = 0;

        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            Character ch = entry.getKey();
            Integer val = entry.getValue();
            if (val > maxFreq) {
                maxFreq = val;
                maxChar = ch;
            }
        }

        return maxChar;
    }
}
