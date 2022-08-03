package com.my.collections.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample3 {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer,String>();
        map.put(100,"Amit");
        map.put(101,"Vijay");
        map.put(102,"Rahul");


//        for (Map.Entry<Integer,String> m : map.entrySet()){
//            System.out.println(m.getKey() + m.getValue());
//        }

        map.putIfAbsent(103, "Gaurav");
//        for (Map.Entry<Integer,String> m : map.entrySet()){
//            System.out.println(m.getKey() + m.getValue());
//        }
        HashMap<Integer,String> map1 = new HashMap<Integer,String>();
        map1.put(104,"Ravi");
        map1.putAll(map);

//        for (Map.Entry<Integer,String> m : map1.entrySet()){
//            System.out.println(m.getKey()+" "+m.getValue());
//        }
    }
}
