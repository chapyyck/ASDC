package WorkWithCSV;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Пример использования
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Roman", 20, "Chisinau", Person.PersonType.STUDENT));
        persons.add(new Person("Mihail", 23, "Moscow", Person.PersonType.EMPLOYEE));
        persons.add(new Person("Elena", 27, "Tiraspol", Person.PersonType.TEACHER));

        // Сериализация в CSV
        CSV.serializeToCSV(persons, "lab_2/WorkWithCSV/output.csv");

        // Десериализация из CSV
        List<Person> deserializedPersons = CSV.deserializeFromCSV("lab_2/WorkWithCSV/output.csv");

        if(deserializedPersons != null){
            System.out.println("\nDeserialization Done =)");
            // Вывод десериализованных объектов
            for (Person person : deserializedPersons) {
                System.out.println(person.toString());
            }
            // Используя полученный список, изменим его и заново сериализуем в новый файл
            deserializedPersons.get(0).setAge(19);
            deserializedPersons.get(1).setAge(47);
            deserializedPersons.add(new Person("Egor", 18, "Bucharest", Person.PersonType.STUDENT));
            deserializedPersons.add(new Person("Vladimir", 39, "Transilvania", Person.PersonType.TEACHER));

            System.out.println("\nSome changes...");
            CSV.serializeToCSV(deserializedPersons, "lab_2/WorkWithCSV/output2.csv");
        }
        else {
            System.out.println("Deserialization Failed =(");
        }
    }
}
