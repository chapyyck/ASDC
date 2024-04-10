package Testing;

import In_place_sort.*;
import static In_place_sort.InPlaceSorting.measureSorting;
import static Testing.GeneratePersons.generateRandomPersonArray;
import WorkWithCSV.Person;
import java.util.Arrays; // убрать

public class Analysis {
    public static void main(String[] args) {

        Person[] randomArray = generateRandomPersonArray(15);
        MyComparator<Person> ageComparator = new AgeComparator();
        MyComparator<Person> nameComparator = new NameComparator();
        MyComparator<Person> cityComparator = new CityComparator();
        MyComparator<Person> typeComparator = new TypeComparator();

        InPlaceSorting<Person> bubbleSort = new BubbleSort<>();
        measureSorting(bubbleSort, randomArray, ageComparator, "random array with using AgeComparator", new InPlaceSorting.SortingMetrics());

//        System.out.println("\nSorted array: " + Arrays.toString(randomArray));

        InPlaceSorting<Person> quickSort = new QuickSort<>();
        measureSorting(quickSort, randomArray, typeComparator, "random array with using typeComparator", new InPlaceSorting.SortingMetrics());

//        System.out.println("\nSorted array: " + Arrays.toString(randomArray));
    }
}