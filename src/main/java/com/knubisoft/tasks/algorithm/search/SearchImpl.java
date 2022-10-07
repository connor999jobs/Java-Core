package com.knubisoft.tasks.algorithm.search;

public class SearchImpl implements Search{
    @Override
    public int binarySearch(long[] array, long v) {
        int low = 0;
        int hight = array.length - 1;
        while (hight - low > 1) {
            int mid = (hight + low) / 2;
            if (array[mid] < v) {
                low = mid + 1;
            }
            else {
                hight = mid;
            }
        }
        if (array[low] == v) {
           return low;
        }
        else if (array[hight] == v) {
            return hight;
        }
        return 0;
    }
}
