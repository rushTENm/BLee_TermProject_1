package TermProject1;

public class Person {
    private String Name;
    private int Age;
    private String Number;

    Person(String Name, int Age, String Number) {
        this.Name = Name;
        this.Age = Age;
        this.Number = Number;
    }

    String getName() {
        return Name;
    }

    int getAge() {
        return Age;
    }

    String getNumber() {
        return Number;
    }
}
