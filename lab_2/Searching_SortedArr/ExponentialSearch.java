package Searching_SortedArr;

public class ExponentialSearch {

    public static int exponentialSearch(int[] arr, int target) {
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