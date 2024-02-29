package demo2;

import java.util.Comparator;
import java.util.PriorityQueue;

class Person implements Comparable<Person>{
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.age-o.age;
    }
}
class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("zhyuxiao", 2);
        Person person2 = new Person("xiaoyuzh", 5);
        NameComparator nameComparator = new NameComparator();
        PriorityQueue<Person> priorityQueue = new PriorityQueue<>(nameComparator);
        priorityQueue.offer(person1);
        priorityQueue.offer(person2);
    }
    public static void main1(String[] args) {
        Person person1 = new Person("zhyuxiao", 2);
        Person person2 = new Person("xiaoyuzh", 5);
        System.out.println(person1.compareTo(person2));
        NameComparator nameComparator = new NameComparator();
        System.out.println(nameComparator.compare(person1, person2));
    }

}
