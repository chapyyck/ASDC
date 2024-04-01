package Time_Analysis;

import java.util.Set;
import static Searching_SortedArr.BinarySearch.standardBinarySearch;
import static Searching_SortedArr.ExponentialSearch.exponentialSearch;
import static Time_Analysis.GeneratingArrays.*;

public class SortedAnalysis {

    static void measureBinarySearch(int[] array, String description, int searchNumber) {
        long startTime = System.nanoTime();
        standardBinarySearch(array, searchNumber);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("BinarySearch search in " + description + ": " + duration + " nanoseconds");
    }

    static void measureExponentialSearch(int[] array, String description, int searchNumber) {
        long startTime = System.nanoTime();
        exponentialSearch(array, searchNumber);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("ExponentialSearch search in " + description + ": " + duration + " nanoseconds");
    }

    public static void main(String[] args) {
        int[] sortedArray = generateSortedArray(10000);
        String strSorted = "Sorted Array ";

        Set<Integer> searchSet = generateSearchSet(100);

        for (int searchNumber : searchSet) {
            System.out.println("\nSearching for number: " + searchNumber);
            measureBinarySearch(sortedArray, strSorted, searchNumber);
            measureExponentialSearch(sortedArray, strSorted, searchNumber);
        }
    }
}