package Singleton;

public class Singleton {
    public static void main(String[] args) {
        System.out.println(Person.getInstance("Maleesha", 26));
        System.out.println(Person.getInstance("Tharuprabha", 27));
    }
}

class Person {
    private String name;
    private int age;
    private static volatile Person person;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person getInstance(String name, int age) {
        if(person == null){
           synchronized (Person.class){
               person = new Person(name, age);
           }
        }
        return person;
    }
}