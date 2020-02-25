package com.algocast.stringreversal;

public class StringReversal {

    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
    }

    public static String reverse(String str) {
        StringBuilder sbr = new StringBuilder();
        for (int i=str.length()-1; i >= 0; i--) {
            sbr.append(str.charAt(i));
        }
        return sbr.toString();
    }
}
