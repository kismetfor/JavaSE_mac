package demo;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();

        System.out.println("====");

        for (Integer i : list) {
            System.out.print(i+" ");
        }
        System.out.println();

        System.out.println("====");

        //迭代器
        ListIterator it = list.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next()+" ");
        }
        System.out.println();

        System.out.println("====");

        ListIterator it2 = list.listIterator(list.size());
        while (it2.hasPrevious()) {
            System.out.print(it2.previous()+" ");
        }
        System.out.println();
    }
    public static void main1(String[] args) {
        myLinkedList my = new myLinkedList();
        my.addLast(1);

        my.display();
//        my.addIndex(2, 19);
        my.display();
    }
}
