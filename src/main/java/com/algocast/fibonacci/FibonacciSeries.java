package com.algocast.fibonacci;

public class FibonacciSeries {
    public static void main(String[] args) {
        System.out.println(getFibonacciSequence(5));
        System.out.println(getFibonacciSequenceIterative(5));
    }

    private static int getFibonacciSequenceIterative(int size) {
        int cur = 1;
        int prev = 1;

        for (int i=3; i<=size; i++) {
            int temp = cur;
            cur += prev;
            prev = temp;
        }

        return cur;
    }
    /**
     * recursive solution
     * @param size
     * @return
     */
    private static int getFibonacciSequence(int size) {
        if (size <= 2)
            return 1;
        else
            return getFibonacciSequence(size - 1) + getFibonacciSequence(size - 2);
    }
}
