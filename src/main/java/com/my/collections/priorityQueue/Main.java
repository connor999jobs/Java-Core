package com.my.collections.priorityQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        Person vadym = new Person("Vadym",0);
        Person adrey = new Person("Andrey",1500);
        Person valik = new Person("Valik", 5000);

        List<Person> personList = new ArrayList<>(Arrays.asList(vadym,adrey,valik));

        PriorityQueue<Person> queue = new PriorityQueue<>(3, new PersonComporator());
        queue.addAll(personList);

        while (!queue.isEmpty()) {
            System.out.println(queue.poll().getName());
        }
    }
}
