package com.knubisoft.base.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class ArraysTasksImpl implements ArraysTasks {

    @Override
    public int[] reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int j = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = j;
        }
        return array;
    }

    @Override
    public int[] mergeArrays(int[] array1, int[] array2) {
        int[] res = Arrays.copyOf(array1, array1.length + array2.length);
        int index = array1.length;
        for (int number : array2) {
            res[index] = number;
            index++;
        }
        return res;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        if (array.length < 3){
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return Arrays.copyOf(array, 3);
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int firstIndex = -1;
        int maxLength = 1;
        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1] && firstIndex == -1) {
                firstIndex = i;
            }
            if (array[i] >= array[i + 1] && firstIndex != -1) {
                int currentLength = i - firstIndex + 1;
                if (maxLength < currentLength) {
                    maxLength = currentLength;
                }
                firstIndex = -1;
            }
            if ( i + 1 == array.length - 1 && array[i] < array[i + 1]) {
                if (firstIndex == -1) {
                    firstIndex = i;
                }
                int currentLength = i + 1 - firstIndex + 1;
                if (maxLength < currentLength) {
                    maxLength = currentLength;
                }
                firstIndex = -1;
            }
        }
        return maxLength;

    }

    @Override
    public int sumOfAllUniqueElements(int[] array) {
        HashSet<Integer> hashSet = new HashSet<>();
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (!hashSet.contains(array[i])){
                sum+= array[i];
                hashSet.add(array[i]);
            }

        }
        return sum;
    }

    @Override
    public int[] moveZeroes(int[] array) {
        int index = 0;
        for (int i:array) {
            if (i!=0){
                array[index++] =i;
            }
        }
        for (int i = index; i < array.length; i++) {
            array[i]=0;
        }
        return array;
    }

    @Override
    public int findFinalValue(int[] nums, int original) {
        boolean flag = true;
        while(flag) {
            flag = false;
            for (int number : nums) {
                if (original == number) {
                    original = number * 2;
                    flag = true;
                }
            }
        }
        return original;
    }

    @Override
    public String longestCommonPrefix(String[] words) {
        int size =words.length;
        if (size==0)
            return "";
        if (size==1)
            return words[0];
        Arrays.sort(words);
        int longestPrefix = Math.min(words[0].length(), words[size-1].length());
        int result = 0;
        while (result < longestPrefix && words[0].charAt(result) == words[size-1].charAt(result))
            result++;
        String resultPrefix = words[0].substring(0,result);
        return resultPrefix;
    }

    @Override
    public int missingNumber(int[] array) {
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        current = array[0];
        for (int number : array) {
            if (current != number) {
                return current;
            }
            current++;
        }
        if (array[0] == 0) {
            return array[array.length - 1] + 1;
        }
        return 0;
    }

    @Override
    public boolean containsDuplicate(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            for (int j = 0; j < i ; ++j) {
                if (array[i] == array[j])
                    return true;
            }

        }
        return false;
    }
}
