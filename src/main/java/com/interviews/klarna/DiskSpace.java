package com.interviews.klarna;

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class DiskSpace {
    public static void main(String[] args) {
        System.out.println(DiskSpace.isWritable(7, 3, new HashSet<>(asList(1, 3, 7))));
    }

    public static boolean isWritable(int blockSize, int fileSize, Set<Integer> occupiedSectors) {

        if (blockSize - occupiedSectors.size() < fileSize) {
            return false;
        }

        boolean isWritable = false;
        int[] occupiedBlocks = new int[(blockSize + 1)];
        occupiedSectors.forEach(sector -> occupiedBlocks[sector] = 1);

        int contiguousFree = 0;

        for (int i = 1; i <= blockSize; i++) {
            contiguousFree = (occupiedBlocks[i] == 0) ? (contiguousFree + 1) : 0;
            if (contiguousFree == fileSize) {
                isWritable = true;
                break;
            }
        }

        return isWritable;
    }
}