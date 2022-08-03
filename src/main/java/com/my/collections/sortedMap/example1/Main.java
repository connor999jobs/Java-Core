package com.my.collections.sortedMap.example1;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        SortedMap<OrderLineId, String> sortedMap = new TreeMap<>();
            OrderLineId k21 = new OrderLineId(2, 1);
            OrderLineId k12 = new OrderLineId(1, 2);
            OrderLineId k11 = new OrderLineId(1, 1);
            OrderLineId k22 = new OrderLineId(2, 2);
            OrderLineId k31 = new OrderLineId(3, 1);
            OrderLineId k23 = new OrderLineId(2, 3);

            sortedMap.put(k21, "Samsung a71");
            sortedMap.put(k12, "IPhone 12");
            sortedMap.put(k11, "Samsung a51");
            sortedMap.put(k22, "IPhone 11");
            sortedMap.put(k31, "IPhone 7");
            sortedMap.put(k23, "Samsung a51");

        Set<OrderLineId> keys = sortedMap.keySet();

        for(OrderLineId key: keys)  {
            String productName = sortedMap.get(key);
            System.out.println("OrderId: " + key.getOrderId() //
                   + key.getLine() + " --> " + productName);
        }
        }
    }

