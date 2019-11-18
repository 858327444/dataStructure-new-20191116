package com.muke.linkedlist;

/**
 * Program Name: dataStructure-new-20191116
 * Created by yanlp on 2019-11-17
 *
 * @author yanlp
 * @version 1.0
 */
public class TestLinkedMain {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
            System.out.println(list);
        }
//        list.add(2,30);
//        System.out.println(list);
//        list.set(3,90);
//        System.out.println(list);
        list.remove(9);
        System.out.println(list);
    }
}
