package com.interviews.talabat;

import java.util.Arrays;
import java.util.Objects;
import java.util.Queue;

/**
 * There is a queue for the self-checkout tills at the supermarket.
 * Your task is write a function to calculate the total time required for all the customers to check out!
 * <p>
 * input:
 * ======
 * customers: an array of positive integers representing the queue.
 * Each integer represents a customer, and its value is the amount of time they require to check out.
 * <p>
 * n: a positive integer, the number of checkout tills (cash desks).
 * <p>
 * output:
 * =======
 * The function should return an integer, the total time required.
 * <p>
 * queueTime([5,3,4], 1)
 * // should return 12
 * // because when there is 1 till, the total time is just the sum of the times
 * <p>
 * queueTime([10,2,3,3], 2)
 * // should return 10
 * // because here n=2 and the 2nd, 3rd, and 4th people in the
 * // queue finish before the 1st person has finished.
 */

public class CheckoutTimeShoppingComplex {
    public static void main(String[] args) {

    }

    public static int checkoutTimeRequired(Queue<Integer> customerQueue, int noOfCounters) {
        int[] countersWeight = new int[noOfCounters];

        while (Objects.nonNull(customerQueue.peek())) {
            Integer currentCustomer = customerQueue.poll();

            int minWaitingTime = Integer.MAX_VALUE;
            int curMinCounter = -1;

            for (int i = 0; i < countersWeight.length; i++) {
                int temp = countersWeight[i];
                if (temp < minWaitingTime) {
                    minWaitingTime = temp;
                    curMinCounter = i;
                }
            }

            countersWeight[curMinCounter] = countersWeight[curMinCounter] + currentCustomer;
        }

        Arrays.sort(countersWeight);

        return countersWeight[countersWeight.length - 1];
    }
}
