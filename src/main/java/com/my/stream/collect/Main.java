package com.my.stream.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Grouping by property
        List<Human> humans = Arrays.asList(
                new Human("Ned", "Stark", 1),
                new Human("Robb", "Stark", 2),
                new Human("Arya", "Stark", 1),
                new Human("Aegon", "Targaryen", 6),
                new Human("Daenerys", "Targaryen", 4),
                new Human("Jaime", "Lannister", 1),
                new Human("Tyrion", "Lannister", 3));

        Map<String, List<Human>> map = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname));

        //Grouping objects by property + count
        Map<String, Long> map1 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.counting()));


        //Grouping objects by property + sum
        Map<String, Integer> map2 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, Collectors.summingInt(Human::getFriendsAmount)));

        Map<String, Set<String>> map3 = humans.stream()
                .collect(Collectors.groupingBy(Human::getSurname, //группируем по фамилии
                        Collectors.mapping(Human::getName, Collectors.toSet()))); // собираем имена в Set



    }
}