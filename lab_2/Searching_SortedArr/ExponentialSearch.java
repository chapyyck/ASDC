package Searching_SortedArr;

import Time_Analysis.Searchable;

public class ExponentialSearch implements Searchable {

    public int search(int[] arr, int target) {
        int border = 1;
        while (border < arr.length && arr[border] < target) {
            border *= 2;
        }
        int left = border / 2;
        int right;

        if (border > arr.length - 1) {
            right = arr.length - 1;
        }
        else {
            right = border;
        }

        return BinarySearch.binarySearch(arr, target, left, right);
    }
}