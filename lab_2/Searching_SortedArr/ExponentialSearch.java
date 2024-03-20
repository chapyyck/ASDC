package Searching_SortedArr;

public class ExponentialSearch {

    public static int binarySearch(int[] arr, int target, int left, int right) {
        while (left <= right) {
            // Делим массив пополам
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

        return binarySearch(arr, target, left, right);
    }
}