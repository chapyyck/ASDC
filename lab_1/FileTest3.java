import java.io.*;

public class FileTest3 {
    public static void main(String[] args) {

        try(
                // Инициализация DataOutputStream для записи примитивных данных в файл test3.bin
                DataOutputStream output = new DataOutputStream(new FileOutputStream("test3.bin"));

                // Инициализация DataInputStream для чтения примитивных данных из файла test3.bin
                DataInputStream input = new DataInputStream(new FileInputStream("test3.bin"));
        )
        {
            // Запись примитивных данных в файл
            output.writeChar(60);
            output.writeInt(19);
            output.writeBoolean(true);

            // Чтение примитивных данных из файла и вывод на экран консоли
            System.out.println(input.readChar());
            System.out.println(input.readInt());
            System.out.println(input.readBoolean());

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}