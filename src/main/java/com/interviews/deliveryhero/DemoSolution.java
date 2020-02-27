package com.interviews.deliveryhero;

public class DemoSolution {
    public static void main(String[] args) {
        System.out.println(smallestPositiveInteger(new int[]{1, 3, 2}));
    }

    static public int smallestPositiveInteger(int[] array) {
        int result = 1;
        int max = 0;

        for (int i = 0; i < array.length; i++) {
            max = Math.max(array[i], max);
        }

        if (max < 1)
            return 1;

        max = array.length > max ? array.length : max;
        max += 2;

        int[] resultArr = new int[max];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                resultArr[array[i]] = 1;
            }
        }

        for (int i = 1; i < resultArr.length; i++) {
            if (resultArr[i] != 1) {
                result = i;
                break;
            }
        }

        return result;
    }
}
