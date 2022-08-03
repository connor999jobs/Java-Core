package com.my.collections.hashMap;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample1 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<Integer,String>();
        map.put(1,"Vadym");
        map.put(2,"Andrey");
        map.put(3,"Dima");
        map.put(4,"Vlad");
        map.put(5,"Valik");


        allValues(map);


    }

    public static void allValues(HashMap<Integer,String> map){
        for (Map.Entry<Integer,String> m : map.entrySet()){
            System.out.println(m.getKey() + " " + m.getValue());
        }
    }
}
