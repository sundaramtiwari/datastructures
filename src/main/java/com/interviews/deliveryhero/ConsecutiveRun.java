package com.interviews.deliveryhero;

public class ConsecutiveRun {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, 3, 6}));
    }

    static public int solution(int[] input) {
        int longestRun = 1;
        int tempLongest = 1;

        int prev = input[0];

        for (int i = 1; i < input.length; i++) {
            int val = input[i];
            if (1 == Math.abs(val - prev)) {
                tempLongest++;
            } else {
                longestRun = Math.max(longestRun, tempLongest);
                tempLongest = 1;
            }
            prev = val;
        }

        longestRun = Math.max(longestRun, tempLongest);

        return longestRun;
    }
}
