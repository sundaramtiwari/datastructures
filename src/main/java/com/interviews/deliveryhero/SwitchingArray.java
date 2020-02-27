package com.interviews.deliveryhero;

public class SwitchingArray {
    public static void main(String[] args) {

    }

    public int solution(int[] input) {
        int arrayLength = input.length;
        if (arrayLength <= 1) return arrayLength;

        int index = 0;
        int maxLength = 0;

        while (index < arrayLength) {
            int current = index;
            int next = index + 1;

            while (next + 2 < arrayLength && input[current] == input[current + 2] && input[next] == input[next + 2]) {
                current += 2;
                next += 2;
            }
            if (current + 2 < arrayLength && input[current] == input[current + 2]) {
                current += 2;
            }
            int end = Math.max(current, next);
            maxLength = Math.max(maxLength, end - index + 1);
            index = end;
        }
        return maxLength;
    }
}
