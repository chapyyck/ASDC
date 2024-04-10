package In_place_sort;

import Testing.MyComparator;

public interface InPlaceSorting<T>{
    void sortInPlace(T[] array, MyComparator<T> comparator, SortingMetrics metrics);

    static <T> void measureSorting(InPlaceSorting<T> sortingAlgorithm, T[] array, MyComparator<T> comparator, String description, SortingMetrics metrics) {
        long startTime = System.nanoTime();
        sortingAlgorithm.sortInPlace(array, comparator, metrics);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println(sortingAlgorithm.getClass().getSimpleName() + " in " + description + " " + duration + " nanoseconds" +
                "\ncomparisons: " + metrics.comparisons + "\nswaps: " + metrics.swaps);
    }

    class SortingMetrics {
        int comparisons;
        int swaps;

        public void incrementComparisons() {
            this.comparisons++;
        }

        public void incrementSwaps() {
            this.swaps++;
        }
    }
}