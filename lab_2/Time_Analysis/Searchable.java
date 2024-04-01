package Time_Analysis;

public interface Searchable {
    int search(int[] array, int searchNumber);
}
class SearchTester {
    static void measureSearch(Searchable searchable, int[] array, String description, int searchNumber) {
        long startTime = System.nanoTime();
        searchable.search(array, searchNumber);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println(searchable.getClass().getSimpleName() + " search in " + description + ": " + duration + " nanoseconds");
    }
}