package Searching_UnsortedArr;

class SearchResult {
    boolean found;
    int index;
    public SearchResult(boolean found, int index) {
        this.found = found;
        this.index = index;
    }
}

public class LinearSearch {
    public static SearchResult linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return new SearchResult(true, i);
            }
        }
        return new SearchResult(false, -1);
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7, 4, 8};
        int target = 7;
        SearchResult result = linearSearch(array, target);

        if (result.found) {
            System.out.println("Элемент " + target + " найден в массиве по индексу " + result.index);
        }
        else {
            System.out.println("Элемент " + target + " не найден в массиве");
        }
    }
}