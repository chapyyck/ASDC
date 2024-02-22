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
        return field != null && !field.contains(",") && field != "";
    }

    public static List<Person> deserializeFromCSV(String filePath) {
        List<Person> persons = new ArrayList<>();
        // единица чтения - линия.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // проверка на кол-во запятых
                int delimiterCount = line.length() - line.replace(",", "").length();
                // разделение line на parts с помощью шаблона regex(запятых)
                String[] parts = line.split(",");

                if (delimiterCount == 3) {
                    if (isValidField(parts[0]) && isValidField(parts[1]) && isValidField(parts[2]) && isValidField(parts[3])) {

                        String name = parts[0];
                        int age = Integer.parseInt(parts[1]);
                        String city = parts[2];
                        Person.PersonType type = Person.PersonType.valueOf(parts[3]);

                        persons.add(new Person(name, age, city, type));
                    } else {
                        System.out.println("Произошла ошибка: поле не может быть пустым или содержать запятую.");
                        return null;
                    }
                } else {
                    System.out.println("Произошла ошибка: кол-во разделителей не соответствует требованиям.");
                    return null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Произошла ошибка: поле не может быть пустым или содержать запятую.");
            return null;
        }

        return persons;
    }

}