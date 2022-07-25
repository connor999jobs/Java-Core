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
        array1 = new int[]{10, 20, 30, 40};
        array2 = new int[]{50, 60, 70, 80};
        int a1 = array1.length;
        int a2 = array2.length;
        int c1 = a1+a2;
        int [] c = new int[c1];
        System.arraycopy(array1,0,c,0,a1);
        System.arraycopy(array2, 0, c, a1, a2);

        System.out.println(Arrays.toString(c));
        return c;
    }

    @Override
    public int[] findMax3InArray(int[] array) {
        if (array.length < 3){
            return array;
        }
        int first=Integer.MIN_VALUE;
        int second=Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int i = 0; i <array.length ; i++) {
            int current = array[i];
            if(first<current){
                third = second;
                second = first;
                first = current;
            }else if(second<current){
                third = second;
                second = current;
            }else if(third<current){
                third=current;
            }
        }
        System.out.println("3 элемента с самым большим значением  : " + first + " " + second + " " + third);
        return array;
    }

    @Override
    public int findLongestIncreasingContinuesSubsequence(int[] array) {
        int max_sequ = 0;
        if (array.length == 1) return 1;
        for (int i = 0; i < array.length - 1; i++) {
            int ctr = 1;
            int j = i;
            if (array[i + 1] > array[i]) {
                while (j < array.length - 1 && array[j + 1] > array[j]) {
                    ctr++;
                    j++;
                }
            } else if (array[i + 1] < array[i]) {
                while (j < array.length - 1 && array[j + 1] < array[j]) {
                    ctr++;
                    j++;
                }
            }
            if (ctr > max_sequ) {
                max_sequ = ctr;
            }
            i += ctr - 2;
        }
        return max_sequ;

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
        int found = original;
        for(int n: nums){
            if(n == original){
                found = findFinalValue(nums, found * 2);
            }

        }
        return found;
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
        int missingNumberArray = array.length;
        int foundNumber = ((missingNumberArray+1)*(missingNumberArray+2))/2;
        for (int i = 0; i < missingNumberArray; i++) {
            foundNumber-=array[i];
        }
        return foundNumber;
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
