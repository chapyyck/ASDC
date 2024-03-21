package Searching_UnsortedArr;

public class LinearSearch {
    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 7, 4, 8};
        int target = 7;
        int result = linearSearch(array, target);

        if (result != -1) {
            System.out.println("Элемент " + target + " найден в массиве по индексу " + result);
        }
        else {
            System.out.println("Элемент " + target + " не найден в массиве");
        }
    }
}