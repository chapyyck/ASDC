import java.io.*;

// Объявляем класс Files_Test
public class FileTest1 {

    public static void main(String[] args) throws IOException {

        // Использование try-with-resources для автоматического закрытия ресурсов
        try (
                // Инициализация объекта BufferedReader для буферизованного чтения из файла
                BufferedReader reader = new BufferedReader(
                        // Инициализация объекта FileReader В КОНСТРУКТОРЕ BufferReader'a для чтения из указанного файла
                        new FileReader("C:\\Users\\37379\\IdeaProjects\\Udemy\\src\\AdvancedJava\\text1.txt")
                );
                // Инициализация объекта BufferedWriter для построчной записи в файла
                BufferedWriter writer = new BufferedWriter(
                        // Инициализация объекта FileWriter в конструкторе BufferedWriter'a для записи в указанный файл
                        new FileWriter("C:\\Users\\37379\\IdeaProjects\\Udemy\\src\\AdvancedJava\\text2.txt")
                );
        ) {
            // Инициализация строки для хранения считанной из файла строки
            String line;
            // Цикл для поочередного чтения строк из файла, пока не достигнут конец файла (null)
            while ((line = reader.readLine()) != null) {
                // Прочитанную строку записываем в новый файл
                writer.write(line);
                // Переходим на новую строку в новом файле
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}