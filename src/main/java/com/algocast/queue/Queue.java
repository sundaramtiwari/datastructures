package com.algocast.queue;

import static java.util.Objects.isNull;

public class Queue<E> {

    private Object[] array;
    private int tail;

    public <T> Queue(int size) {
        this.array = new Object[size];
        tail = -1;
    }

    public void enqueue(E element) {
        if (tail == array.length - 1)
            throw new RuntimeException("Queue is full");

        array[++tail] = element;
    }

    public E dequeue() {
        if (isNull(array[0]))
            throw new RuntimeException("Queue is empty. Cannot get element");

        E element = (E) array[0];

        // shift all other elements 1 step
        for (int i = 1; i <= tail; i++) {
            array[i - 1] = array[i];
        }

        return element;
    }
}
