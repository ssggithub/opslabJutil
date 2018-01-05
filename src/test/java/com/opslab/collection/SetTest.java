package com.opslab.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {

        // 1.迭代遍历：
        Set<String> set = new HashSet<String>();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
        }

        // 2.for循环遍历：
        for (String str : set) {
            System.out.println(str);
        }


        //优点还体现在泛型 假如 set中存放的是Object

        Set<Object> set1 = new HashSet<Object>();
        //for循环遍历：
        for (Object obj : set1) {
            if (obj instanceof Integer) {
                int aa = (Integer) obj;
            } else if (obj instanceof String) {
                String aa = (String) obj;
            }
            // ........
        }

    }


}
