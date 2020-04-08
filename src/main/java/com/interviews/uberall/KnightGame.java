package com.interviews.uberall;

import java.util.Random;

public class KnightGame {

    public static void main(String[] args) {
        int size = 6;

        Node node1 = new Node("knight_1");
        Node node2 = new Node("knight_2");
        node1.setNext(node2);

        Node node3 = new Node("knight_3");
        node2.setNext(node3);

        Node node4 = new Node("knight_4");
        node3.setNext(node4);

        Node node5 = new Node("knight_5");
        node4.setNext(node5);

        Node node6 = new Node("knight_6");
        node5.setNext(node6);
        node6.setNext(node1);

        // ties starting point to node1
        Node current = node1;

        // n1 -> n2 -> n1 -> n2;
        while (current.getNext() != current) {
            Random r = new Random();
            int i = r.nextInt(6) + 1;

            // reduce the health of next node
            Node next = current.getNext();
            next.setHealth(next.getHealth() - i);
            System.out.println(current.getName() + " hits " + next.getName() + " by damage: " + i + " new health: " + next.getHealth());

            // if next node health < 0, evict it
            if (next.getHealth() < 1) {
                System.out.println(next.getName() + " dies.");
                current.setNext(next.getNext());
            }

            current = current.getNext();
        }

        System.out.println(current.getName() + " is the winner");
    }
}

class Node {

    private String name;
    private int health;
    private Node next;

    public Node(String name) {
        this.health = 100;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
