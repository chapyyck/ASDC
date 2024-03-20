package Searching_SortedArr;

import static Searching_SortedArr.BinarySearch.binarySearch;
import static Searching_SortedArr.ExponentialSearch.exponentialSearch;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 23};
        int target = 15;

        int resultOfBinarySearch = binarySearch(arr, target);
        int resultOfExponentialSearch = exponentialSearch(arr, target);

        if (resultOfBinarySearch == resultOfExponentialSearch) {
            if (resultOfBinarySearch == -1) {
                System.out.println("Элемент " + target + " не найден");
            }
            else {
                System.out.println("Элемент " + target + " найден в позиции " + resultOfBinarySearch);
            }
        }
    }
}