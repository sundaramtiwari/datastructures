package com.interviews.deliveryhero;

/**
 * Write a function that give a zero indexed sorted array A
 * consisting of N integers and an integer Y, returns an
 * integer that is count of Y in array A.
 * <p>
 * Can you implement it with O(Log N) time complexity?
 */
public class OccurrenceInSortedArray {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-1, -2, 0, 1, 2, 2, 2}, 3));
    }

    static public int solution(int[] A, int Y) {
        int size = A.length;
        int numOfOccurrences = 0;
        int index = binarySearch(A, 0, size, Y);

        if (index > -1) {
            numOfOccurrences = 1;

            int left = index - 1;
            while (left >= 0 &&
                    A[left] == Y) {
                numOfOccurrences++;
                left--;
            }

            int right = index + 1;
            while (right < size &&
                    A[right] == Y) {
                numOfOccurrences++;
                right++;
            }
        }

        return numOfOccurrences;
    }

    static int binarySearch(int[] array, int leftIndex, int rightIndex, int key) {
        if (rightIndex < leftIndex)
            return -1;

        int mid = (rightIndex - leftIndex) / 2;

        if (array[mid] == key)
            return mid;

        if (array[mid] > key)
            return binarySearch(array, leftIndex, mid - 1, key);

        return binarySearch(array, mid + 1, rightIndex, key);
    }

    static int binarySearch(int search, int[] array) {

        int start = 0;
        int end = array.length - 1;

        while (start <= end) {

            int middle = (start + end) / 2;

            if (search < array[middle]) {
                end = middle - 1;
            }

            if (search > array[middle]) {
                start = middle + 1;
            }

            if (search == array[middle]) {
                return middle;
            }
        }
        return -1;
    }
}
