package Searching_SortedArr;

public class BinarySearch {

    public static int standardBinarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        return binarySearch(arr, target, left, right);
    }

    public static int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > target) {
                right = mid - 1;
            }
            else if (arr[mid] < target) {
                left = mid + 1;
            }
            else if (arr[mid] == target) {
                return mid;
            }
        }

        return -1;
    }
}