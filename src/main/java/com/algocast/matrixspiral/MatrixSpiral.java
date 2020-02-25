package com.algocast.matrixspiral;

import java.util.HashMap;
import java.util.Map;

import static com.algocast.matrixspiral.Direction.*;

public class MatrixSpiral {
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
        matrix[0][0] = 1;

        Node node = new Node(0, 0, 1, EAST);

        // max we need to iterate till we hit the max number i.e., size * size
        while (node.getVal() < size * size) {
            traverseMatrix(size, matrix, node);
        }

        return matrix;
    }

    private static void traverseMatrix(int size, int[][] matrix, Node node) {
        // check for next block in direction within limits
        int curRow = node.getRow();
        int curCol = node.getCol();
        Direction curDirection = node.getDirection();

        if (EAST.equals(curDirection)) {
            // check for boundary condition or an element
            if (curCol == size - 1 || matrix[curRow][curCol + 1] != 0) {
                turnAndTraverseStep(node);

            } else {
                traverseStep(curDirection, node);
            }
        } else if (WEST.equals(curDirection)) {
            if (curCol == 0 || matrix[curRow][curCol - 1] != 0) {
                turnAndTraverseStep(node);
            } else {
                traverseStep(curDirection, node);
            }
        } else if (NORTH.equals(curDirection)) {
            if (curRow == 0 || matrix[curRow - 1][curCol] != 0) {
                turnAndTraverseStep(node);
            } else {
                traverseStep(curDirection, node);
            }
        } else {
            if (curRow == size - 1 || matrix[curRow + 1][curCol] != 0) {
                turnAndTraverseStep(node);
            } else {
                traverseStep(curDirection, node);
            }
        }

        matrix[node.getRow()][node.getCol()] = node.getVal();

    }

    private static void turnAndTraverseStep(Node node) {
        // we must change direction
        Direction direction = MOVE_MAP.get(node.getDirection());
        node.setDirection(direction);
        traverseStep(direction, node);
    }

    private static void traverseStep(Direction direction, Node node) {
        node.setVal(node.getVal() + 1);
        switch (direction) {
            case EAST:
                node.setCol(node.getCol() + 1);
                break;
            case WEST:
                node.setCol(node.getCol() - 1);
                break;
            case NORTH:
                node.setRow(node.getRow() - 1);
                break;
            case SOUTH:
                node.setRow(node.getRow() + 1);
                break;
        }
    }

    private static final Map<Direction, Direction> MOVE_MAP = new HashMap<>();

    static {
        MOVE_MAP.put(EAST, SOUTH);
        MOVE_MAP.put(SOUTH, WEST);
        MOVE_MAP.put(WEST, NORTH);
        MOVE_MAP.put(NORTH, EAST);
    }
}

class Node {
    int row;
    int col;
    int val;
    Direction direction;

    public Node(int row, int col, int val, Direction direction) {
        this.row = row;
        this.col = col;
        this.val = val;
        this.direction = direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public Direction getDirection() {
        return direction;
    }
}

enum Direction {
    EAST, WEST, NORTH, SOUTH
}
