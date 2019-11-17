package com.muke.stack;

import com.muke.array.Array;

/**
 * Program Name: dataStructure-new-20191116
 * Created by yanlp on 2019-11-17
 *
 * @author yanlp
 * @version 1.0
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> array;

    public ArrayStack(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayStack() {
        array = new Array<>();
    }


    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.getLast();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack : ");
        res.append(" [ ");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));
            if ( i != array.getSize() - 1) {
                res.append(" , ");
            }
        }
        res.append(" ] top");

        return res.toString();
    }
}
