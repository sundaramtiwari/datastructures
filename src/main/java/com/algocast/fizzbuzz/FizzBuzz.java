package com.algocast.fizzbuzz;

import java.util.stream.IntStream;

public class FizzBuzz {

    public static void main(String[] args) {
        fizzbuzz(30);
    }

    private static void fizzbuzz(int i) {
        IntStream.rangeClosed(1, i).forEach(num -> {
            if (num % 15 == 0)
                System.out.println("fizzbuzz");
            else if (num % 3 == 0)
                System.out.println("fizz");
            else if (num % 5 == 0)
                System.out.println("buzz");
            else
                System.out.println(num);
        });
    }
}
