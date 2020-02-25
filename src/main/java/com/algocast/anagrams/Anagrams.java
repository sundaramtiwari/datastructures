package com.algocast.anagrams;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(areAnagrams("cab", "abc"));
    }

    public static boolean areAnagrams(String stringA, String stringB) {
        if (isNull(stringA) || isNull(stringB) ||
                stringA.length() == 0 ||
                stringA.length() != stringB.length())
            return false;

        char[] strArrA = stringA.toCharArray();
        char[] strArrB = stringB.toCharArray();
        Map<Character, Integer> charMap = new HashMap<>(strArrA.length);

        for (int i = 0; i < strArrA.length; i++) {
            charMap.put(strArrA[i], charMap.containsKey(strArrA[i]) ? charMap.get(strArrA[i]) + 1 : 1);
        }

        for (int i = 0; i < strArrB.length; i++) {
            Integer curVal = charMap.get(strArrB[i]);
            if (isNull(curVal))
                return false;
            if (curVal > 1)
                charMap.put(strArrB[i], --curVal);
            else
                charMap.remove(strArrB[i]);
        }

        return charMap.isEmpty();
    }
}
