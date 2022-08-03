package com.my.collections.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "Vadym");
        map.put(2, "Andrey");
        map.put(3, "Dima");
        map.put(4, "Vlad");
        map.put(1, "Valik");

        iteratingMap(map);
    }

    public static void iteratingMap(Map<Integer,String> map){
        for (Map.Entry<Integer,String> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());

        }
    }
}
