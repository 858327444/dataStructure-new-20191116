package com.muke.array;

/**
 * 数组
 * Program Name: Array
 * Created by yanlp on 2019-11-16
 *
 * @author yanlp
 * @version 1.0
 */
public class Array<E> {
    private E[] data;
    private int size;

    // 构造函数,传入数组的容量
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    // 无参构造器
    public Array() {
        this(10);
    }

    // 数组是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 获取数组已存储元素个数
    public int getSize() {
        return size;
    }

    // 获取数组容量
    public int getCapacity() {
        return data.length;
    }

    // 数组末尾添加元素
    public void addLast(E e) {
        add(size, e);
    }

    // 数组首添加元素
    public void addFirst(E e) {
        add(0, e);
    }


    // 向任意索引位置添加元素
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fail.Require  index >= 0 and index <= size ");
        }
        if (size == data.length) {
            // 扩容
            resize(2 * data.length);
        }
        // 从最后一个元素依次向后移
        for (int i = size -1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    // 获取索引位置的元素
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        return data[index];
    }

    // 设置索引位置的元素
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed.Index is illegal");
        }
        data[index] = e;
    }

    // 是否包含元素e
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    // 查找元素对应的第一个索引,如果找不到返回-1
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    // 删除索引位置的元素
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Delete fail.Require  index >= 0 and index <= size ");
        }
        E ret = data[index];
        for (int i = index; i <= size-1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        // 当元素个数为数组容量的1/4时才开始扩容,一种懒惰的方式 .还得保证缩容后,数组的容量不能为0
        if (size == data.length / 4 && data.length / 2 != 0) {
            // 缩容
            resize(data.length / 2);
        }
        return  ret;
    }

    // 删除第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除某一个值为e的¬元素
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array size = %d, capacity = %d \n", size, getCapacity()));
        res.append(" [ ");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(" , ");
            }
        }
        res.append(" ] ");
        return res.toString();
    }
}
