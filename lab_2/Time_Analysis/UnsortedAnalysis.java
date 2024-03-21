package Time_Analysis;

import Searching_UnsortedArr.BinaryTreeSearch;
import java.util.Set;
import static Searching_UnsortedArr.LinearSearch.linearSearch;
import static Time_Analysis.GeneratingArrays.*;

public class UnsortedAnalysis {

    static void measureLinearSearch(int[] array, String description, int searchNumber) {
        long startTime = System.nanoTime();
        linearSearch(array, searchNumber);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Linear search in " + description + ": " + duration + " nanoseconds");
    }

    static void measureBinaryTreeSearch(int[] array, String description, int searchNumber) {
        BinaryTreeSearch binaryTree = new BinaryTreeSearch();
        binaryTree.addElements(array);
        long startTime = System.nanoTime();
        binaryTree.search(searchNumber);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("BinaryTree search in " + description + ": " + duration + " nanoseconds");
    }

    public static void main(String[] args) {
        int[] sortedArray = generateSortedArray(10000);
        int[] reversedArray = generateReversedArray(10000);
        int[] randomArray = generateRandomArray(10000);
        String strSorted = "Sorted Array ";
        String strReversed = "Reversed Array ";
        String strRandom = "Random Array ";

        // 100 разных чисел для поиска
        Set<Integer> searchSet = generateSearchSet(100);

        for (int searchNumber : searchSet) {
            System.out.println("\nSearching for number: " + searchNumber);

            measureLinearSearch(sortedArray, strSorted, searchNumber);
            measureLinearSearch(reversedArray, strReversed, searchNumber);
            measureLinearSearch(randomArray, strRandom, searchNumber);

            measureBinaryTreeSearch(sortedArray, strSorted, searchNumber);
            measureBinaryTreeSearch(reversedArray, strReversed, searchNumber);
            measureBinaryTreeSearch(randomArray, strRandom, searchNumber);
        }
    }
}