package com.muke.queue;

/**
 * 循环队列
 * Program Name: dataStructure-new-20191116
 * Created by yanlp on 2019-11-18
 *
 * @author yanlp
 * @version 1.0
 */
public class LoopQueue<E> implements Queue<E> {
    // 元素数组
    private E[] data;
    // 队首元素所在索引
    private int front;
    // 下一个新的队尾元素索引
    private int tail;
    // 元素个数
    private int size;

    public LoopQueue(int capacity) {
        // 有意识的浪费掉一个空间
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    public LoopQueue() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        return size;
    }


    @Override
    public void enqueue(E e) {

        if ((tail + 1) % data.length == front) {
            resize(2 * getCapacity());
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;

        size++;
    }

    /**
     * 重置容量
     *
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        // 有意识的浪费掉一个空间
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;

    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");

        }
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue size = %d, capacity = %d \n", size, getCapacity()));
        res.append("front [ ");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);
            if ((i + 1) % data.length != tail) {
                res.append(" , ");
            }
        }
        res.append(" ] tail");
        return res.toString();
    }


    public static void main(String[] args) {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue);

        }
    }
}
