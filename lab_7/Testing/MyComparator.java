package Testing;

import WorkWithCSV.Person;

public interface MyComparator<T> {
    int compare(T obj1, T obj2);
}

class AgeComparator implements MyComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.age - p2.age;
    }
}

class NameComparator implements MyComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.name.compareTo(p2.name);
    }
}

class CityComparator implements MyComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.city.compareTo(p2.city);
    }
}

class TypeComparator implements MyComparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.type.compareTo(p2.type);
    }
}