package Testing;

import In_place_sort.*;
import static Testing.GeneratePersons.generateRandomPersonArray;
import static Testing.Sorting.SortingMetrics.measureSorting;

import WorkWithCSV.Person;
import java.util.Arrays; // убрать

public class Analysis {
    public static void main(String[] args) {

        Person[] randomArray = generateRandomPersonArray(15);
        MyComparator<Person> ageComparator = new AgeComparator();
        MyComparator<Person> nameComparator = new NameComparator();
        MyComparator<Person> cityComparator = new CityComparator();
        MyComparator<Person> typeComparator = new TypeComparator();

        Sorting<Person, Void> bubbleSort = new BubbleSort<>();
        measureSorting(bubbleSort, randomArray, ageComparator, "random array with using AgeComparator", new Sorting.SortingMetrics());

//        System.out.println("\nSorted array: " + Arrays.toString(randomArray));

//        Sorting<Person, Void> quickSort = new QuickSort<>();
//        measureSorting(quickSort, randomArray, typeComparator, "random array with using TypeComparator", new SortingMetrics());
//
//        System.out.println("\nSorted array: " + Arrays.toString(randomArray));
    }
}