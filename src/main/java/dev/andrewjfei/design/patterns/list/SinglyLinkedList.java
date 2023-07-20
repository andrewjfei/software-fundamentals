package dev.andrewjfei.design.patterns.list;

import java.rmi.UnexpectedException;

public class SinglyLinkedList<T> {
    private SinglyLinkedListNode<T> head;
    private SinglyLinkedListNode<T> tail;
    private int size;

    public SinglyLinkedList() {
        size = 0;
    }

    public SinglyLinkedList(T element) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(element);
        head = node;
        tail = node;
        size = 1;
    }

    /**
     * Add an element to the end of the {@code SinglyLinkedList}.
     * <br>
     * <br>
     * Time Complexity: {@code O(1)}
     * <br>
     * <br>
     * @param element
     */
    public void add(T element) {
        SinglyLinkedListNode<T> node = new SinglyLinkedListNode<>(element);

        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
        }

        tail = node;
        size++;
    }

    /**
     * Get the element at the specified index in the {@code SinglyLinkedList}.
     * <br>
     * <br>
     * Time Complexity: {@code O(n)}
     * <br>
     * <br>
     * @param index
     */
    public T get(int index) throws UnexpectedException {
        validateIndex(index);

        int counter = 0;
        SinglyLinkedListNode<T> current = head;

        while (counter < size) {
            if (index == counter) {
                return current.getElement();
            }

            counter++;
            current = current.getNext();
        }

        throw new UnexpectedException("This exception should never be thrown.");
    }

    /**
     * Remove the element at the specified index in the {@code SinglyLinkedList}.
     * <br>
     * <br>
     * Time Complexity: {@code O(n)}
     * <br>
     * <br>
     * @param index
     */
    public void remove(int index) {
        validateIndex(index);

        if (index == 0) {
            head = head.getNext();
            size--;
        }

        int counter = 1;
        SinglyLinkedListNode<T> current = head;

        while (counter < size + 1) {
            if (index == counter) {
                current.setNext(current.getNext().getNext());
                size--;
                break;
            }

            counter++;
            current = current.getNext();
        }
    }

    /**
     * Check whether the specified element exists in the {@code SinglyLinkedList}.
     * <br>
     * <br>
     * Time Complexity: {@code O(n)}
     * <br>
     * <br>
     * @param element
     */
    public boolean contains(T element) {
        SinglyLinkedListNode<T> current = head;

        while (current != null) {
            if (element.equals(current.getElement())) {
                return true;
            }

            current = current.getNext();
        }

        return false;
    }

    /**
     * Get the size of the {@code SinglyLinkedList}.
     * <br>
     * <br>
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * Check whether the {@code SinglyLinkedList} is empty.
     * <br>
     * <br>
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Validate if the provided index is within the bounds of the {@code SinglyLinkedList} size.
     * <br>
     * <br>
     * @param index
     */
    private void validateIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
    }
}
