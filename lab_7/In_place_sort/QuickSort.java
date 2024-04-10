package In_place_sort;

import Testing.MyComparator;

public class QuickSort<T> implements InPlaceSorting<T> {

    @Override
    public void sortInPlace(T[] array, MyComparator<T> comparator, SortingMetrics metrics) {
        quickSort(array, comparator, 0, array.length - 1, metrics);
    }

    private void quickSort(T[] array, MyComparator<T> comparator, int low, int high, SortingMetrics metrics) {
        if (low < high) { // есть как минимум 2 элемента
            int j = partition(array, comparator, low, high, metrics);
            quickSort(array, comparator, low, j, metrics);
            quickSort(array, comparator, j + 1, high, metrics);
        }
        metrics.incrementComparisons();
    }

    private int partition(T[] array, MyComparator<T> comparator, int low, int high, SortingMetrics metrics) {
        T pivot = array[low];
        int i = low - 1;
        int j = high + 1;

        while (true) {
            do {
                i++;
                metrics.incrementComparisons();
            } while (comparator.compare(array[i], pivot) < 0);

            do {
                j--;
                metrics.incrementComparisons();
            } while (comparator.compare(array[j], pivot) > 0);

            if (i >= j) {
                return j;
            }
            metrics.incrementComparisons();

            T temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            metrics.incrementSwaps();

//          System.out.println(Arrays.toString(array)); - отслеживание каждого свапа
        }
    }
}