package Testing;

public interface Sorting<T, R> {
    R sort(T[] array, MyComparator<T> comparator, SortingMetrics metrics);
}