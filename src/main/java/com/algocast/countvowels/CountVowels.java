package com.algocast.countvowels;

import java.util.HashSet;
import java.util.Set;

public class CountVowels {

    public static void main(String[] args) {
        System.out.println(countVowels("Why do you ask?"));
    }

    private static int countVowels(String string) {
        int vowelCount = 0;
        Set<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('e');
        vowelSet.add('i');
        vowelSet.add('o');
        vowelSet.add('u');

        char[] chars = string.toCharArray();

        for (int i=0; i<chars.length; i++) {
            char curChar = chars[i];
            if (vowelSet.contains(curChar))
                vowelCount++;
        }

        return vowelCount;
    }
}
