package com.knubisoft.tasks.algorithm.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SortImpl implements Sort {

    @Override
    public Map<Integer, List<Integer>> sortKeysAndValues(Map<Integer, List<Integer>> input) {
        Map<Integer, List<Integer>> sortKeysAndValues = new HashMap<>();
        int counter =0;
        for (Map.Entry<Integer, List<Integer>> eachSortKeysAndValues : input.entrySet()){
            counter++;
            sortKeysAndValues.put(eachSortKeysAndValues.getKey(),
                    input.get(counter).stream().sorted().collect(Collectors.toList()));
        }
        return sortKeysAndValues;
    }

}
