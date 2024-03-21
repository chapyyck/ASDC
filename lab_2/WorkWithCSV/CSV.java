package WorkWithCSV;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSV {
    public static void serializeToCSV(List<Person> persons, String filePath) {
        // try-with-resources автоматически закроет ресурсы
        // PrintWriter - удобно, есть метод записи целой строки + переброс на nextline
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (Person person : persons) {
                writer.println(person.toString());
            }
            System.out.println("Serialization to file " + filePath + " completed!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Проверка - является ли допустимым поле
    private static boolean isValidField(String field) {
        return field != null && field != "";
    }

    public static List<Person> deserializeFromCSV(String filePath) {
        List<Person> persons = new ArrayList<>();
        // единица чтения - линия.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",", 4);
                if (parts.length != 4) {
                    System.err.println("Произошла ошибка: кол-во разделителей не соответствует требованиям.");
                    return null;
                }

                for (String part : parts) {
                    if (!isValidField(part)) {
                        System.err.println("Произошла ошибка: поле не может быть пустым или содержать запятую.");
                        return null;
                    }
                }

                String name = parts[0];
                int age = Integer.parseInt(parts[1]);
                String city = parts[2];
                PersonType type = PersonType.valueOf(parts[3]);

                persons.add(new Person(name, age, city, type));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Произошла ошибка: поле не может быть пустым или содержать запятую.");
            return null;
        }
        catch (IllegalArgumentException e) {
            System.err.println("Ошибка в ENUM. (Проверь запятые)");
            return null;
        }

        return persons;
    }
}