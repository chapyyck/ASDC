package Queue;

import WorkWithCSV.Person;
import WorkWithCSV.PersonType;

public class Main {
    public static void main(String[] args) {
        Queue<Person> queue = new Queue<Person>();

        queue.addLast(new Person("Maxim", 32, "Chisinau", PersonType.EMPLOYEE));
        queue.addLast(new Person("Liudmila", 77, "Chisinau", PersonType.TEACHER));

        if (!queue.isEmpty()) {
            System.out.println("Следующий на очереди: " + queue.getFirst().data);

            Node<Person> test = queue.getAndRemoveFirst();
            System.out.println("Обработаем следующего на очереди: " + test.data);

            System.out.println("Следующий на очереди: " + queue.getFirst().data);
        }
        else {
            System.out.println("Очередь пуста");
        }
    }
}