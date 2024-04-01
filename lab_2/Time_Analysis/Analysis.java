package Time_Analysis;

import Searching_SortedArr.*;
import Searching_UnsortedArr.*;
import static Searching_UnsortedArr.BinaryTreeSearch.measureBinaryTreeSearch;
import static Time_Analysis.GeneratingArrays.*;

public class Analysis {

    public static void main(String[] args) {
        int[] sortedArray = generateSortedArray(10000);
        int[] reversedArray = generateReversedArray(10000);
        int[] randomArray = generateRandomArray(10000);
        String strSorted = "Sorted Array ";
        String strReversed = "Reversed Array ";
        String strRandom = "Random Array ";

        Searchable linearSearch = new LinearSearch();
        Searchable binarySearch = new BinarySearch();
        Searchable exponentialSearch = new ExponentialSearch();
        // binary tree не подогнан под интерфейс

        int[] searchArray = generateSearchArray(100);

        for (int searchNumber : searchArray) {
            System.out.println("\nSearching for number: " + searchNumber);

            SearchTester.measureSearch(linearSearch, sortedArray, strSorted, searchNumber);
            SearchTester.measureSearch(linearSearch, reversedArray, strReversed, searchNumber);
            SearchTester.measureSearch(linearSearch, randomArray, strRandom, searchNumber);

            SearchTester.measureSearch(binarySearch, sortedArray, strSorted, searchNumber);

            SearchTester.measureSearch(exponentialSearch, sortedArray, strSorted, searchNumber);

            measureBinaryTreeSearch(sortedArray, strSorted, searchNumber);
            measureBinaryTreeSearch(reversedArray, strReversed, searchNumber);
        }
    }
}