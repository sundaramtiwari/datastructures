package com.interviews.glovo;

public class MatrixColouring {

    public static void main(String[] args) {

        int[][] array = {
                {5, 4, 4},
                {4, 3, 4},
                {3, 2, 4},
                {2, 2, 2},
                {3, 3, 4},
                {1, 4, 4},
                {4, 1, 1}};
        System.out.println(solution(array));
    }

    static public int solution(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] copy = new int[row][col];

        int countries = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (copy[i][j] != 1) {
                    countries++;
                    int val = A[i][j];
                    copy[i][j] = 1;

                    markNeighboursVisited(A, copy, i, j, val);
                }
            }
        }

        return countries;
    }

    private static void markNeighboursVisited(int[][] a, int[][] copy, int i, int j, int val) {
        // north
        markVisited(a, copy, i, j - 1, val);
        // south
        markVisited(a, copy, i, j + 1, val);
        // east
        markVisited(a, copy, i + 1, j, val);
        // west
        markVisited(a, copy, i - 1, j, val);
    }

    private static void markVisited(int[][] a, int[][] copy, int i, int j, int val) {
        if (i > -1 && i < a.length) {
            if (j > -1 && j < a[0].length) {
                if (copy[i][j] != 1 && a[i][j] == val) {
                    copy[i][j] = 1;
                    markNeighboursVisited(a, copy, i, j, val);
                }
            }
        }
    }
}
