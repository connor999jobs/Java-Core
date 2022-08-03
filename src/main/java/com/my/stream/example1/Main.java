package com.my.stream.example1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //Stream filter + forEach

        List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        integers.stream()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);


        //Stream filter + count
        List<String> names = Arrays.asList("John", "Jan", "Tirion", "Marry", "Nikolas");
        long count = names.stream()
                .filter(i -> i.length() > 4)
                .count();

        long count2 = count;


        // Stream + multiple filters

        List<String> names2 = Arrays.asList("John", "Daenerys", "Tyrion", "", null, "Arya");

        names2.stream()
                .filter(Objects::nonNull)
                .filter(name -> !name.isEmpty() && name.contains("a"))
                .forEach(System.out::println);



    }

    //Grouping objects by property + count


}
