package com.knubisoft.base.arrays;

import java.util.*;

public class Test extends ArraysTasksImpl{


    public static void main(String[] args)
    {
        Test gfg = new Test();
//        int [] massive = {1,2,3,6,12,21,24};
//        int target = 3;
//        System.out.println("findFinalValue: " + gfg.findFinalValue(massive,target));
//        String[] input = {"knubisoft", "knubiroft", "knuisoft", "knu","knr"};
//        System.out.println( "The longest Common Prefix is : " +
//                gfg.longestCommonPrefix(input));

        int[] massive = new int[]{1,2,3,4,1};
        System.out.println("Answer is: " + gfg.containsDuplicate(massive));
    }

}