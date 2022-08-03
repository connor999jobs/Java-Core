package com.my.collections.sortedMap.example2;

import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMap_subMap_ex1 {
    public static void main(String[] args) {
        SortedMap<String, String> myMap = new TreeMap<>();

        myMap.put("A", "VA");
        myMap.put("B", "VB");
        myMap.put("C", "VC");
        myMap.put("D", "VD");
        myMap.put("E", "VE");

        // A Sub Map
//        SortedMap<String, String> subMap = myMap.subMap("B", "C1");

//        System.out.println(" -- subMap --");
//        for (String s : subMap.keySet()) {
//            System.out.println(s + " --> " + subMap.get(s));
//        }

//        subMap.put("B1", "VB1");
//        subMap.put("B2", "VB2");

        SortedMap<String, String> headMap = myMap.headMap("E");
//        System.out.println(" -- subMap (after putting some mappings to subMap) --");
//        for (String s : subMap.keySet()) {
//            System.out.println(s + " --> " + subMap.get(s));
//        }
//
//        System.out.println(" -- myMap (after putting some mappings to subMap) --");
//        for (String s : myMap.keySet()) {
//            System.out.println(s + " --> " + myMap.get(s));
//        }
    }
}
