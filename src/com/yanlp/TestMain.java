package com.yanlp;

import com.yanlp.array.Array;

/**
 * Program Name: Array
 * Created by yanlp on 2019-11-16
 *
 * @author yanlp
 * @version 1.0
 */
public class TestMain {
    public static void main(String[] args) {
        Array<Integer> array = new Array<>();
        for (int i = 0; i < 10; i++) {
            array.addLast(i);
        }
        System.out.println(array);

        array.add(1,90);
        System.out.println(array);


        System.out.println(array);
        array.remove(0);

        System.out.println(array);

    }
}
