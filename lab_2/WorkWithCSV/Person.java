package WorkWithCSV;

public class Person {
    public String name;
    public int age;
    public String city;
    public PersonType type;

    public Person(String name, int age, String city, PersonType type) {
        this.name = name;
        this.age = age;
        this.city = city;
        this.type = type;
    }

    // Для проведения изменений при повторной сериализации
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + "," + age + "," + city + "," + type;
    }
}