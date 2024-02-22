import java.io.*;

// Объявляем класс Files_Test2
public class FileTest2 {
    // Основной метод main, где начинается выполнение программы
    public static void main(String[] args) throws IOException {

        // Используется try-with-resources для автоматического закрытия ресурсов
        try (
                // Инициализация FileInputStream для чтения данных из файла old_page.webp
                FileInputStream input = new FileInputStream(
                        "C:\\Users\\37379\\Desktop\\old_page.webp");
                // Инициализация FileOutputStream для записи данных в файл new_page.webp
                FileOutputStream output = new FileOutputStream(
                        "C:\\Users\\37379\\IdeaProjects\\Udemy\\src\\AdvancedJava\\new_page.webp");
        ) {
            // Цикл для поочередного чтения байтов из input и записи в output
            int character;
            while ((character = input.read()) != -1) {
                output.write(character);
            }
        }
        catch (IOException exc) {
            throw exc;
        }
        finally {
            System.out.println("DONE !");
        }



    }
}