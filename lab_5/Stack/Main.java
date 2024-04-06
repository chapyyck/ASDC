package Stack;

import WorkWithCSV.Person;
import WorkWithCSV.PersonType;

public class Main {
    public static void main(String[] args) {

        /** LinkedStack Test **/
        LinkedStack<Person> linkedStack = new LinkedStack<>();

        linkedStack.push(new Person("Roman", 20, "Chisinau", PersonType.STUDENT));
        linkedStack.push(new Person("Anton", 41, "Orhei", PersonType.TEACHER));
        linkedStack.push(new Person("Olga", 55, "Balti", PersonType.EMPLOYEE));

        if(!linkedStack.isEmpty()) {
            System.out.println("Последний элемент стека: " + linkedStack.getLastElement());

            Person test = linkedStack.pop();
            System.out.println("Извлечем верхушку: " + test);

            System.out.println("Последний элемент стека: " + linkedStack.getLastElement());
        }
        else {
            System.out.println("Стек пуст");
        }

        /** ArrayStack Test **/
        ArrayStack<Person> arrayStack = new ArrayStack<>();

        arrayStack.push(new Person("Eugene", 37, "Chisinau", PersonType.EMPLOYEE));
        arrayStack.push(new Person("Elena", 29, "Moscow", PersonType.TEACHER));
        arrayStack.push(new Person("Mihail", 18, "London", PersonType.STUDENT));

        if(!arrayStack.isEmpty()) {
            System.out.println("\nПоследний элемент стека: " + arrayStack.getLastElement());

            Person test = arrayStack.pop();
            System.out.println("Извлечем верхушку: " + test);

            System.out.println("Последний элемент стека: " + arrayStack.getLastElement());
        }
        else {
            System.out.println("\nСтек пуст");
        }
    }
}