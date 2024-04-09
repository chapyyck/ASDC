package In_place_sort;

import java.util.Comparator;

public class BubbleSort<T> implements InPlaceSorting<T> {

    @Override
    public void sortInPlace(T[] array, Comparator<T> comparator, SortingMetrics metrics) {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                metrics.incrementComparisons();
                if (comparator.compare(array[j], array[j + 1]) > 0)
                {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    metrics.incrementSwaps();

//                  System.out.println(Arrays.toString(array)); - отслеживание каждого свапа
                }
            }
        }
    }
}