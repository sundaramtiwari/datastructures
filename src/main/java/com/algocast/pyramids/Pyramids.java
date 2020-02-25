package com.algocast.pyramids;

public class Pyramids {
    public static void main(String[] args) {
        //printPyramids(4);
        printPyramidsRecursive(7, 1);
    }

    private static void printPyramidsRecursive(int rows, int curRow) {
        int cols = rows*2 - 1;

        int diff = rows - curRow;
        for (int i=0; i<cols; i++) {
            if (i < diff || i >= cols - diff)
                System.out.print(" ");
            else
                System.out.print("#");
        }
        if (++curRow <= rows) {
            System.out.println();
            printPyramidsRecursive(rows, curRow);
        }
        else return;
    }

    private static void printPyramids(int rows) {
        int cols = (rows * 2) - 1;

        // iterate for each row
        for (int i=1; i <= rows; i++) {
            // print for each column with size cols
            int diff = rows - i;
            for (int j=0; j < cols; j++) {
                if (j < diff || j >= cols - diff)
                    System.out.print(" ");
                else
                    System.out.print("#");
            }
            System.out.println();
        }
    }
}
