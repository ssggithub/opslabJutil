package com.opslab.collection;

import java.util.*;

public class CollectionConvert {
    private static List<String> arrayList;
    private static Map<String, String> hashMap;
    private static Set<String> hashSet;
    private static String[] arr = {"11oneone", "22twotwo"};

    public static void main(String[] args) {

        //list转换为set
        initList();
        Set<String> set1 = new HashSet<String>(arrayList);
        System.out.println("arrayList----->" + arrayList.toString());
        System.out.println("set----------->" + set1.toString());


        //set转换为list
        initSet();
        List<String> list1 = new ArrayList<>(hashSet);
        System.out.println("list----->" + list1.toString());
        System.out.println("hashSet-->" + hashSet.toString());

        //数组转换为list
        List<String> list2 = Arrays.asList(arr);
        System.out.println("list2----->" + list2.toString());

        //数组转换为set
        Set set2 = new HashSet<>(Arrays.asList(arr));
        System.out.println("set2------>" + set2.toString());

        //map的值转为list
        initMap();
        List<String> list3 = new ArrayList<>(hashMap.values());
        System.out.println("list3---->" + list3.toString());

        //map的值转为set
        initMap();
        Set<String> set3 = new HashSet<String>(hashMap.values());
        System.out.println("set3----->" + set3.toString());

        //map的key转为set
        initMap();
        Set<String> set4 = new HashSet<String>(hashMap.keySet());
        System.out.println("set4----->" + set4.toString());

        //list转数组
        initList();
        String[] arr1 = (String[]) arrayList.toArray(new String[arrayList.size()]);
        System.out.println("arr1------>" + Arrays.toString(arr1));
    }

    public static void initList() {
        arrayList = new ArrayList<String>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
    }

    public static void initMap() {
        hashMap = new HashMap<String, String>();
        hashMap.put("one", "one1");
        hashMap.put("two", "two2");
        hashMap.put("three", "three3");
    }

    public static void initSet() {
        hashSet = new HashSet<String>();
        hashSet.add("1one");
        hashSet.add("2two");
        hashSet.add("3three");
        hashSet.add("4four");
        hashSet.add("5five");
    }
}
