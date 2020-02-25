package com.algocast.printingsteps;

public class PrintingSteps {
    public static void main(String[] args) {
        printSteps(5);
        printSteps(3, 1, new StringBuilder());
    }

    private static void printSteps(int steps, int row, StringBuilder stair) {
        if (steps == row)
            return;

        if (steps == stair.length()) {
            System.out.println(stair);
            printSteps(steps, ++row, new StringBuilder());
            return;
        }

        if (stair.length() < row)
            stair.append("#");
        else
            stair.append(" ");

        printSteps(steps, row, stair);
    }
    /**
     * Iterative solution
     * @param steps
     */
    private static void printSteps(int steps) {
        for (int i=0; i < steps; i++) {
            StringBuilder sbr = new StringBuilder();
            for (int j=0; j < steps; j++) {
                if (j <= i) {
                    sbr.append("#");
                } else {
                    sbr.append(" ");
                }
            }
            System.out.println(sbr);
        }
    }
}
