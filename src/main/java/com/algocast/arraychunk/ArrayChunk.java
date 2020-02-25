package com.algocast.arraychunk;

public class ArrayChunk {

    public static void main(String[] args) {
        int[][] response = chunk1(new int[]{1, 2, 3, 4, 5}, 3);

        for (int i=0; i<response.length; i++) {
            System.out.print("[");
            for (int j=0; j<response[i].length; j++) {
                System.out.print(response[i][j]);
            }
            System.out.print("]");
        }
    }

    private static int[][] chunk1(int[] ints, int size) {
        int subArrLen = (ints.length) % size != 0 ? (ints.length) / size + 1 : (ints.length) / size;
        int[][] response = new int[subArrLen][size];
        int[] temp = new int[ints.length > size ? size : ints.length];
        int tempIndex = 0;
        int countRow = 0;

        for (int i=0; i < ints.length; i++) {
            if (i > 0 && i % size == 0) {
                for (int j=0; j < temp.length; j++) {
                    response[countRow][j] = temp[j];
                }
                countRow++;
                int remainingElements = ints.length-i > size ? size : ints.length-i;
                temp = new int[remainingElements];
                tempIndex = 0;
            }

            temp[tempIndex++] = ints[i];
        }

        for (int j=0; j < temp.length; j++) {
            response[countRow][j] = temp[j];
        }

        return response;
    }
    private static int[][] chunk(int[] ints, int size) {
        int[][] response = (ints.length)%size != 0 ? new int[(ints.length)/size + 1][size] : new int[(ints.length)/size][size];

        for (int i = 0, count = 0; i < ints.length; i += size, count++) {
            for (int j = i, countCol = 0; j < i+size && j < ints.length; j++, countCol++) {
                response[count][countCol] = ints[j];
            }
        }
        return response;
    }
}
