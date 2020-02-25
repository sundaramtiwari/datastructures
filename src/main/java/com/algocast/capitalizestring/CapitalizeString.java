package com.algocast.capitalizestring;

public class CapitalizeString {
    public static void main(String[] args) {
        System.out.println(capitalizeStringNew("my name is sundaram"));
    }

    private static String capitalizeString(String string) {
        String[] strArr = string.split(" ");
        StringBuilder sbr = new StringBuilder();

        for (String str : strArr) {
            sbr.append((str.charAt(0) + "").toUpperCase()).append(str.substring(1)).append(" ");
        }

        return sbr.toString().trim();
    }

    private static String capitalizeStringNew(String string) {
        StringBuilder sbr = new StringBuilder();
        sbr.append(string.substring(0,1).toUpperCase());

        char[] chars = string.toCharArray();

        for (int i=1; i < chars.length; i++) {
            if (chars[i-1] == ' ')
                sbr.append((chars[i] + "").toUpperCase());
            else
                sbr.append(chars[i]);
        }

        return sbr.toString();
    }
}
