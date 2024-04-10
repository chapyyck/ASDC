package Not_in_place_sort;

import Testing.MyComparator;
import Testing.Sorting;
import Testing.SortingMetrics;
import java.util.List;

public interface NotInPlaceSorting<T> extends Sorting<T, List<T>> {
    @Override
    List<T> sort(T[] array, MyComparator<T> comparator, SortingMetrics metrics);
}