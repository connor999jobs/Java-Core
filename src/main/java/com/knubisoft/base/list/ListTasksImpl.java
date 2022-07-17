package com.knubisoft.base.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ListTasksImpl implements ListTasks {
    @Override
    public List<String> addElements(String... elements) {
        List<String> list = Arrays.asList(elements);

        return list;
    }

    @Override
    public List<String> getElementsByIndexes(List<String> elements, int[] indexes) {

        for(int in : indexes){
            elements.get(in);
        }
        return elements;
    }

    @Override
    public ArrayList<String> addElementsByIndexes(ArrayList<String> elements, int[] indexes) {
        for (int i : indexes){
            elements.add(i,elements.get(i));
        }
        return elements;
    }

    @Override
    public LinkedList<String> setElementsByIndexes(LinkedList<String> elements, int[] indexes) {
        for (int i : indexes){
            elements.set(i, elements.get(i));
        }
        return elements;
    }

    @Override
    public int getListSize(List<String> list) {

        return list.size();
    }

    @Override
    public List<Long> merge(List<Integer> first, List<Long> second, List<String> third) {

        List<Integer> integersList = first;
        List<Long> merge1 = integersList.stream()
                .map(Integer::longValue)
                .collect(Collectors.toList());
        List<Long> merge2 = second;

        List<String> stringList = third;
        List<Long> merge3 = stringList.stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());

        List<Long> allMerge = new ArrayList<>();
        allMerge.addAll(merge1);
        allMerge.addAll(merge2);
        allMerge.addAll(merge3);

        return allMerge;
    }

    @Override
    public int findMaxValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(first);
        mergeList.addAll(second);
        mergeList.addAll(third);
        Collections.sort(mergeList);

        return mergeList.get(mergeList.size() - 1);
    }

    @Override
    public int findMinValue(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(first);
        mergeList.addAll(second);
        mergeList.addAll(third);
        Collections.sort(mergeList);
        return mergeList.get(0);
    }

    @Override
    public int multiplyMax2Elements(List<Integer> first, List<Integer> second, List<Integer> third) {
        List<Integer> mergeList = new ArrayList<>();
        mergeList.addAll(first);
        mergeList.addAll(second);
        mergeList.addAll(third);
        Collections.sort(mergeList);
        int a = mergeList.get(mergeList.size()-1);
        int b = mergeList.get(mergeList.size()-2);
        int c = a*b;
        return c;
    }

    @Override
    public List<String> removeNulls(List<String> list) {
        list.removeAll(Collections.singletonList(null));
        return list;
    }

    @Override
    public List<Integer> flatMapWithoutNulls(List<List<Integer>> list) {

        list = list.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        return null;
    }

    @Override
    public List<Integer> cloneIds(List<Integer> originalIds) {
        List<Integer> list = new ArrayList<>(originalIds);
        list.removeAll(Collections.singletonList(null));
        return list;
    }

    @Override
    public List<String> shuffle(List<String> originalStrings) {
        Collections.shuffle(originalStrings);
        return originalStrings;
    }

    @Override
    public String getLastElement(LinkedList<String> list) {
        String last = list.peekLast();
        return last;
    }

    @Override
    public List<String> compareElements(LinkedList<String> originalCollection, LinkedList<String> additionalCollection) {

        return null;
    }
}
