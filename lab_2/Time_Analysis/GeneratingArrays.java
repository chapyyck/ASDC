package Time_Analysis;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class GeneratingArrays {
    static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    static int[] generateReversedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (size - i) - 1;
        }
        return array;
    }

    static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    static Set<Integer> generateSearchSet(int size) {
        Set<Integer> searchSet = new HashSet<>();
        Random random = new Random();
        while (searchSet.size() < size) {
            searchSet.add(random.nextInt(10000));
        }
        return searchSet;
    }
}