package com.interviews.deliveryhero;

public class OCR {
    public static void main(String[] args) {
        System.out.println(solution("A22Le", "2pL1"));
    }

    public static String expand(String s) {
        StringBuilder expansionBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i))) {
                expansionBuilder.append(s.charAt(i));
            } else {
                int temp = i;
                StringBuilder tempBuilder = new StringBuilder();
                while (temp < s.length() && Character.isDigit(s.charAt(temp))) {
                    tempBuilder.append(s.charAt(temp++));
                }

                int num = Integer.parseInt(tempBuilder.toString());
                for (int j = 0; j < num; j++) {
                    expansionBuilder.append('?');
                }
            }
        }

        return expansionBuilder.toString();
    }

    public static boolean solution(String S, String T) {
        String expandedFirstInput = expand(S);
        String expandedSecondInput = expand(T);

        if (expandedFirstInput.length() != expandedSecondInput.length()) {
            return false;
        }

        for (int i = 0; i < expandedFirstInput.length(); i++) {
            if (expandedFirstInput.charAt(i) != '?' && expandedSecondInput.charAt(i) != '?'
                    && expandedFirstInput.charAt(i) != expandedSecondInput.charAt(i)) {
                return false;
            }
        }

        return true;
    }
}
