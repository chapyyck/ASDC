package Testing;

import WorkWithCSV.Person;
import WorkWithCSV.PersonType;
import java.util.Random;

public class GeneratePersons {

    public static Person[] generateRandomPersonArray(int size) {

        Person[] array = new Person[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            String name = generateRandomName();
            int age = random.nextInt(83) + 18;
            String city = generateRandomCity();
            PersonType type = PersonType.values()[random.nextInt(PersonType.values().length)];
            array[i] = new Person(name, age, city, type);
        }
        return array;
    }

    private static String generateRandomName() {
        String[] names = {"Maxim", "Liudmila", "Roman", "Anton", "Olga", "Sergei", "Natalia", "Vladimir", "Anna", "Dmitry", "Elena", "Egor"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }

    private static String generateRandomCity() {
        String[] cities = {"Chisinau", "Orhei", "Balti", "Cahul", "Tiraspol", "Comrat", "Soroca", "Moscow", "Minsk", "Drochia", "Rybnitsa", "Dubasari"};
        Random random = new Random();
        return cities[random.nextInt(cities.length)];
    }
}
