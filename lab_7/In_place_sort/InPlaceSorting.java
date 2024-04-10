package In_place_sort;

import Testing.MyComparator;
import Testing.Sorting;
import Testing.SortingMetrics;

public interface InPlaceSorting<T> extends Sorting<T, Void> {
    @Override
    Void sort(T[] array, MyComparator<T> comparator, SortingMetrics metrics);
}