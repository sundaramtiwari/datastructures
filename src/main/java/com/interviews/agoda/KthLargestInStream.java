package com.interviews.agoda;

import java.util.ArrayList;
import java.util.Arrays;

/*

        Given a stream of integers, find the K'th Largest element

        a stream of integers
        [5, 8, 2, 4, 7]
        3rd largest
        // if a new number comes, and its lower than the current k'th largest, we can ignore
        // if its greater than kth then:
        //
        // 8, 7, 5, 4, 2
        // Step: 1: sort these first k elements= [8, 7 , 5, 4, 2], k=3
        // Step: 2: get array[3] = 4 as root.
        // Node, left, right: 7 as root of right subtree and then
        // 2<- 4 -> ((4.5 <- 5) <- 7 -> 8)
        // we can start processing new elements:
        // if we get '6' as the next integer
        // (i) traverse right sub-tree and get the left-most leaf node
        // (ii) compare the value of this leaf node with the new element in stream
        // (iii) if leaf node is smaller than the new element, leaf node becomese root
        // else the new element becomes the root and we discard the current root.

        // i-1'th element is i'th largest. O(nlogn)
        //

        */

public class KthLargestInStream {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");

        for (String string : strings) {
            System.out.println(string);
        }
    }

    static int getKthLargestInStream(Node root, int newNumber) {
        if (newNumber < root.getData())
            return root.getData();
        else {
            // we need to traverse till the left-most leaf:
            Node parent = root;
            Node temp = root.getRight();
            while (temp.getLeft() != null) {
                parent = temp;
                temp = temp.getLeft();
            }

            if (temp.getData() < newNumber) {
                root.setData(temp.getData());
                parent.setLeft(null);
                // add newNumber to the rightSubTree
                // insertTree(

            } else {
                // just set the root here
                root.setData(newNumber);
            }
        }

        return root.getData();
    }

    static int getKthLargestElement(int[] input, int k) {
        Arrays.sort(input);

        int rootData = input[k];
        Node root = new Node(rootData, null, null);

        int[] rightArray = new int[k];

        // 8, 7, 5, 4, 2 -> 8, 7, 5
        for (int i = k + 1; i < input.length; i++) {
            rightArray[i] = input[i];
        }

        int[] leftArray = new int[k];

        // 8, 7, 5, 4, 2 -> 8, 7, 5
        for (int i = 0; i < k; i++) {
            rightArray[i] = input[i];
        }

        // Node buildTree(int root, leftArray, rightArray)
        // Node root = new Node(rootData, null, null);
        // if (leftArray != null || leftArray.size() > 0)
        //   Node leftChild = buildTree(leftArray[mid], leftLeftSubarray, rightLeftArray);
        // if (rightArray != null || rightArray.size() > 0)
        //   Node rightChild = buildTree(rightArray[mid], leftRightSubarray, rightRightArray);
        // return root;


        return -1;
    }
}

class Node {
    private int data;
    private Node left;
    private Node right;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getData() {
        return this.data;
    }

    public Node getLeft() {
        return this.left;
    }

    public Node getRight() {
        return this.right;
    }
}
