package dev.andrewjfei.design.patterns.list;

public class SinglyLinkedListNode<T> {
    private T element;
    private SinglyLinkedListNode<T> next;

    public SinglyLinkedListNode(T element) {
        this.element = element;
    }

    public SinglyLinkedListNode(T element, SinglyLinkedListNode<T> next) {
        this.element = element;
        this.next = next;
    }

    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public SinglyLinkedListNode<T> getNext() {
        return next;
    }

    public void setNext(SinglyLinkedListNode<T> next) {
        this.next = next;
    }
}
