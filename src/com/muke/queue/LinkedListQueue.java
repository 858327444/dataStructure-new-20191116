package com.muke.queue;

/**
 * 基于链表实现的队列
 * 从tail端入队,从head端出队
 * Program Name: dataStructure-new-20191116
 * Created by yanlp on 2019-11-21
 *
 * @author yanlp
 * @version 1.0
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public Node next;
        public E e;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }

    }

    // 头部元素
    private Node head;
    // 尾部元素
    private Node tail;
    private int size;

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        Node retNode = head;
        head = head.next;
        retNode.next = null;
        if (head == null) {
            tail = null;
        }
        size--;
        return retNode.e;
    }

    @Override
    public E getFront() {
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
