package com.knubisoft.base.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test extends  ListTasksImpl{
    public static void main(String[] args) {
        Test test = new Test();

        List<Integer> list = Arrays.asList( 1, 2, 3, 4, 5 );

        List<Long> newList = list.stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        System.out.println(newList);

//        ArrayList<String> arrayList = new ArrayList<>();
//        arrayList.add(0,"Vadym");
//        arrayList.add(1,"Vlad");
//        arrayList.add(2,"Andrey");
//        System.out.println(arrayList);
//        arrayList.add(2,"Vlad");
//        System.out.println(arrayList);
//        arrayList.set(2,"V");
//        System.out.println(arrayList);



//        ArrayList<String> newArray = new ArrayList<>(Arrays.asList("Alex", "Bob", "Alica"));
//        System.out.println(newArray);

    }
}
