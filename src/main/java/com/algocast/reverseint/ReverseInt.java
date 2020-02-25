package com.algocast.reverseint;

public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverseInt(-87800));
    }

    private static int reverseInt(int i) {
        int abs = i < 0 ? -i : i;
        StringBuilder sbr = new StringBuilder().append(abs).reverse();

        if (i < 0) {
            return Integer.parseInt('-' + sbr.toString());
        }

        else return Integer.parseInt(sbr.toString());
    }
}
