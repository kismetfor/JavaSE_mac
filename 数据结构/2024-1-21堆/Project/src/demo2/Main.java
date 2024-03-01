package demo2;

import java.util.Arrays;
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
class Imp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}

public class Main {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,2,4,6,8};
        int[] ret = smallestK(arr, 4);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] smallestK(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Imp());
        if (k==0|| arr.length==0) {
            return new int[0];
        }
        int i = 0;
        for (; i < k; i++) {
            maxHeap.offer(arr[i]);
        }
        for (; i < arr.length; i++) {
            if (maxHeap.peek() > arr[i]) {
                maxHeap.poll();
                maxHeap.offer(arr[i]);
            }
        }
        int[] ret = new int[k];
        for (i = 0; i < k; i++) {
            ret[i] = maxHeap.poll();
        }
        return ret;
    }
    public static void main2(String[] args) {
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
