package com.opslab.collection;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
// 遍历方法一 hashMap.entrySet() 遍历
        System.out.println("方法一");
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println("key = " + key + "; value = " + value);
        }
        System.out.println("");
        // 遍历方法二
        System.out.println("方法二");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.println("key =" + key + " value = " + value);
        }
        System.out.println("");
// 遍历方法三 hashMap.keySet().iterator() 遍历
        System.out.println("方法三");
        for (Iterator<String> i = map.keySet().iterator(); i.hasNext(); ) {
            String key = i.next();
            System.out.println(" key = " + key + "; value = " + map.get(key));
        }

        System.out.println("");
// 遍历方法四 Hashmap.keySet()遍历
        System.out.println("方法四");
        for (String key : map.keySet()) {
            System.out.println("key = " + key + "; value = " + map.get(key));
        }
        System.out.println();
// java如何遍历Map <String, ArrayList> map = new HashMap <String, ArrayList<Integer> >();
        System.out.println("java 遍历Map <String, ArrayList<Integer> map = new HashMap <String, ArrayList<Integer>>();");
        System.out.println("方法一：");
        Map<String, List<Integer>> mapList = new HashMap<String, List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        mapList.put("aaa", list);
        mapList.put("bbb", list);
        Set<String> keys = mapList.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key + " : ");
            List<Integer> arrayList = mapList.get(key);
            for (Integer i : arrayList) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
        System.out.println("方法二：");
        for (Map.Entry<String, List<Integer>> entry : mapList.entrySet()) {
            String key = entry.getKey();
            System.out.println(key + " : ");
            List<Integer> values = (List<Integer>) entry.getValue();
            for (Integer value : values) {
                System.out.print(value + ", ");
            }
            System.out.println();
        }
    }
}
