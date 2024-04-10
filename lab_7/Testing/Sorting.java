package Testing;

public interface Sorting<T, R> {
    R sort(T[] array, MyComparator<T> comparator, SortingMetrics metrics);

    class SortingMetrics {
        public int comparisons;
        public int swaps;

        public void incrementComparisons() {
            this.comparisons++;
        }

        public void incrementSwaps() {
            this.swaps++;
        }

        static <T, R> void measureSorting(Sorting<T, R> sortingAlgorithm, T[] array, MyComparator<T> comparator, String description, SortingMetrics metrics) {
            long startTime = System.nanoTime();
            sortingAlgorithm.sort(array, comparator, metrics);
            long endTime = System.nanoTime();
            long duration = endTime - startTime;

            System.out.println(sortingAlgorithm.getClass().getSimpleName() + " in " + description + " " + duration + " nanoseconds" +
                    "\ncomparisons: " + metrics.comparisons + "\nswaps: " + metrics.swaps);
        }
    }
}