package Searching_SortedArr;

import Time_Analysis.Searchable;

class Main {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 23};
        int target = 15;

        Searchable binarySearch = new BinarySearch();
        int resultOfBinarySearch = binarySearch.search(arr, target);

        Searchable exponentialSearch = new ExponentialSearch();
        int resultOfExponentialSearch = exponentialSearch.search(arr, target);

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