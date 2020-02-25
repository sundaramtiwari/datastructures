package com.interviews.amazon;

import java.util.List;

public class Solution2 {
    public static void main(String[] args) {

    }

    public static int minimumDays(int rows, int columns, List<List<Integer>> grid) {
        int[][] gridArr = new int[rows][columns];
        int[][] gridArrTemp = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            List<Integer> integers = grid.get(i);
            for (int j = 0; j < columns; j++) {
                gridArr[i][j] = integers.get(j);
                gridArrTemp[i][j] = integers.get(j);
            }
        }

        int count = 0;
        boolean foundZero = false;
        boolean resume = true;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (gridArr[i][j] == 0) {
                    foundZero = true;
                    break;
                }
            }
        }

        while (resume) {
            boolean updated = false;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (gridArr[i][j] == 1) {
                        if (i > 0 && gridArr[i - 1][j] == 0) {
                            gridArrTemp[i - 1][j] = 1;
                            updated = true;
                        }

                        if (i < rows - 1 && gridArr[i + 1][j] == 0) {
                            gridArrTemp[i + 1][j] = 1;
                            updated = true;
                        }

                        if (j > 0 && gridArr[i][j - 1] == 0) {
                            gridArrTemp[i][j - 1] = 1;
                            updated = true;
                        }

                        if (j < columns - 1 && gridArr[i][j + 1] == 0) {
                            gridArrTemp[i][j + 1] = 1;
                            updated = true;
                        }
                    }
                }
            }

            if (updated) {
                count++;
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    if (gridArrTemp[i][j] == 0) {
                        foundZero = true;
                        break;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    gridArr[i][j] = gridArrTemp[i][j];
                }
            }

            resume = false;
            if (foundZero) {
                if (updated) {
                    resume = true;
                }
            }
        }

        return count;
    }
}
