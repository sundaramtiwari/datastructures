package com.interviews.deliveryhero;

import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/number-of-burgers-with-no-waste-of-ingredients/discuss/?currentPage=1&orderBy=hot&query=
 */
public class Burgers {
    public static void main(String[] args) {
        int[] solution = solution(16, 7);
        System.out.println(solution);
    }

    public int[] solution1(int X, int Y) {
        int[] result = {-1, -1};

        if (Y < X) return result;

        for (int i = 0; i <= X; i++) {
            if ((i * 4) + (X - i) * 2 == Y) {
                result[0] = X - i;
                result[1] = i;
            }
        }
        return result;
    }

    static public int[] solution(int X, int Y) {
        int[] result = {-1, -1};
        if (Y < X) return result;

        IntStream.rangeClosed(0, X).filter(i -> (i * 4) + (X - i) * 2 == Y).forEach(i -> {
            result[0] = X - i;
            result[1] = i;
        });

        return result;
    }
}
