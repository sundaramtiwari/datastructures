package com.algocast.matrixspiral;

public class MatrixSpiralBruteForce {

    public static void main(String[] args) {
        int[][] spiralMatrix = createSpiralMatrix(3);

        for (int i = 0; i < spiralMatrix.length; i++) {
            for (int j = 0; j < spiralMatrix.length; j++) {
                System.out.print(spiralMatrix[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] createSpiralMatrix(int size) {
        int[][] matrix = new int[size][size];

        int counter = 1;
        int startRow = 0;
        int endRow = size - 1;
        int startCol = 0;
        int endCol = size - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Traverse start Row
            for (int i = startCol; i <= endCol; i++) {
                matrix[startRow][i] = counter++;
            }
            // Decrement the start row
            startRow++;

            // Traverse end Column
            for (int i = startRow; i <= endRow; i++) {
                matrix[i][endCol] = counter++;
            }
            // Decrement the end column
            endCol--;

            // Traverse end row
            for (int i = endCol; i >= startCol; i--) {
                matrix[endRow][i] = counter++;
            }
            endRow--;

            // Traverse start col
            for (int i = endRow; i >= startRow; i--) {
                matrix[i][startCol] = counter++;
            }
            startCol++;
        }

        return matrix;
    }
}
