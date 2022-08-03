package com.my.collections.navigablemap;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapEx1 {

    public static void main(String[] args) {
        // Map: World Cup Year --> Country Name
        NavigableMap<Integer, String> worldCupMap = new TreeMap<>();

        worldCupMap.put(1934, "Italy");
        worldCupMap.put(1930, "Uruguay");
        worldCupMap.put(1970, "Mexico");
        worldCupMap.put(1966, "England");
        worldCupMap.put(1962, "Chile");
        worldCupMap.put(1958, "Sweden");
        worldCupMap.put(1954, "Switzerland");
        worldCupMap.put(1950, "Brazil");
        worldCupMap.put(1938, "France");

//        System.out.println("--- World Cup Map ---:");
        printMap(worldCupMap);

        // Get a reverse view of the navigable map.
        NavigableMap<Integer, String> reverseMap = worldCupMap.descendingMap();

//        System.out.println("\n--- World Cup Map (Reverse View) ---:");
        printMap(reverseMap);

        // World Cup Map (Year >= 1935)
        NavigableMap<Integer, String> tailMap1 = worldCupMap.tailMap(1935, true);

//        System.out.println("\n--- World Cup Map (Year >= 1935) ---:");
        printMap(tailMap1);

        // World Cup Map (Year <= 1958)
        NavigableMap<Integer, String> headMap1 = worldCupMap.headMap(1938, true);

//        System.out.println("\n--- World Cup Map (Year <= 1938) ---:");
        printMap(headMap1);

        // The first year of the World Cup after 1938.
        int year1 = worldCupMap.higherKey(1938);
//        System.out.printf("%nThe first year of the World Cup after 1938: %d%n", year1);

        // The last year of the World Cup before 1950.
        int year2 = worldCupMap.lowerKey(1950);
//        System.out.printf("%nThe last year of the World Cup before 1950: %d%n", year2);

        // The first World Cup after 1938.
        Map.Entry<Integer, String> e1 = worldCupMap.higherEntry(1938);
//        System.out.printf("%nThe first World Cup after 1938: %d --> %s%n", e1.getKey(), e1.getValue());

        // The last World Cup before 1950.
        Map.Entry<Integer, String> e2 = worldCupMap.lowerEntry(1950);
//        System.out.printf("%nThe last World Cup before 1950: %d --> %s%n", e2.getKey(), e2.getValue());
    }

    private static void printMap(Map<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " --> " + entry.getValue());
        }
    }
}