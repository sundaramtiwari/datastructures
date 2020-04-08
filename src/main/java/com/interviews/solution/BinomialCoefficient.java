package com.interviews.solution;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class BinomialCoefficient {

    private static final BigInteger UPPER_BOUND = BigInteger.valueOf(1000000000);
    private static final BigInteger LOWER_BOUND = BigInteger.valueOf(0);
    private static final int MAX_CACHE_SIZE = Integer.MAX_VALUE / 10000;
    private static Map<Integer, BigInteger> factorialMap = new HashMap<>(MAX_CACHE_SIZE);


    public static void main(String[] args) {
        System.out.println(solution(3, 5));
    }

    static public int solution(int N, int K) {
        BigInteger factN = getFactorial(N);
        BigInteger factK = getFactorial(K);
        BigInteger factNK = getFactorial(N - K);

        BigInteger result = factN.divide(factK.multiply(factNK));

        if ((LOWER_BOUND.equals(result)) || (UPPER_BOUND.compareTo(result) == -1))
            return -1;
        else
            return result.intValue();
    }

    static BigInteger getFactorial(int n) {

        if (factorialMap.containsKey(n)) {
            return factorialMap.get(n);
        }

        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {

            if (factorialMap.containsKey(i)) {
                result = factorialMap.get(i);

            } else {
                result = result.multiply(BigInteger.valueOf(i));
                if (factorialMap.size() < MAX_CACHE_SIZE)
                    factorialMap.put(i, result);
            }
        }

        return result;
    }
}
