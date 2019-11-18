package com.muke.linkedlist;

import com.muke.stack.ArrayStack;
import com.muke.stack.Stack;

import java.util.Random;

/**
 * Program Name: dataStructure-new-20191116
 * Created by yanlp on 2019-11-17
 *
 * @author yanlp
 * @version 1.0
 */
public class TestArrayAndLinkedListStack {
    public static Double testStack(Stack<Integer> stack,int opCount) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) /1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;
        Stack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("ArrayStack: "+testStack(arrayStack, opCount));
        Stack<Integer> linkedListStack = new LinkedListStack<>();
        System.out.println("LinkedListStack: "+testStack(linkedListStack, opCount));

    }
}
