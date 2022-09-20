package com.my;

import java.io.Externalizable;
import java.io.FilterWriter;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
//        int sum = 0;
//        for ( int i =0, j = 0; i < 5 & j < 5; ++i, j = i +1){
//            sum += i;
//        }
//        System.out.println(sum);
        modify();



}

    public static void modify(){
        Consumer<List<Integer>> modFirst = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, 2 * list.get(i));
            }
        };

        Consumer<List<Integer>> modSecond = list -> {
            list.stream().map(a -> Math.pow(a, 2));
        };

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(-1);
        list.add(2);

        modFirst.accept(list);
        modSecond.accept(list);

        list.forEach(a -> System.out.println(a + " "));

    }




}

