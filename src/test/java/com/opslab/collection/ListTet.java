package com.opslab.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTet {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        long start = 0L;
        long end = 0L;
        for (int j = 0; j < 1000000; j++) {
            list.add("aaaaaa" + j);
        }

        start = System.currentTimeMillis();
        for (String tmp : list) {
        }
        end = System.currentTimeMillis();
        System.out.print("第一种方法运行时间:" + (end - start) + "(毫秒)\n");


        start = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        end = System.currentTimeMillis();
        System.out.print("第二种方法运行时间:" + (end - start) + "(毫秒)\n");


        Iterator<String> iter = list.iterator();

        start = System.currentTimeMillis();
        while (iter.hasNext()) {
            iter.next();
        }
        end = System.currentTimeMillis();
        System.out.print("第三种方法运行时间:" + (end - start) + "(毫秒)\n");
    }
}
