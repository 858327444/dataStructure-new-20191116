package com.muke.queue;

/**
 * 队列
 * Program Name: dataStructure-new-20191116
 * Created by yanlp on 2019-11-17
 *
 * @author yanlp
 * @version 1.0
 */
public interface Queue<E> {
    /**
     * 从队列尾 进入队列
     * @param e
     */
    void enqueue(E e);

    /**
     * 从队首取出元素
     */
    E dequeue();

    /**
     * 获取队首元素
     * @return
     */
    E getFront();

    /**
     * 队列个数
     * @return
     */
    int getSize();

    /**
     * 队列是否为空
     * @return
     */
    boolean isEmpty();



}
