package demo2;

import java.util.Objects;

class Student {
    String id;

    public Student(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

public class HashBuck {
    static class Node {
        int key;
        int val;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    Node[] array = new Node[10];
    int usedSize;
    static final double LOAD_FACTOR = 0.75;
    void push(int key, int val) {
        Node node = new Node(key, val);
        int index = key % array.length;
        if (array[index]==null) {
            array[index] = node;
            usedSize++;
            if (doLoadFactor() >= 0.75) {
                reSize();
            }
            return;
        }

        Node cur = array[index];
        while (cur != null) {
            if (cur.key==key) {
                //key相同更新val
                cur.val = val;
                return;
            }
            cur = cur.next;
        }

        //头插
        node.next = array[index];
        array[index].next = node;
        usedSize++;

        if (doLoadFactor() >= 0.75) {
            reSize();
        }
    }
    private void reSize() {
        Node[] newArray = new Node[array.length*2];

        for (int i = 0; i < array.length; i++) {
            Node cur = array[i];
            while (cur!=null) {
                int index = cur.key % newArray.length;
                Node curNext = cur.next;
                cur.next = newArray[index];
                newArray[index] = cur;
                cur = curNext;
            }
        }

        array = newArray;
    }

    int get(int key) {
        int index = key % array.length;
        Node cur = array[index];
        while (cur!=null) {
            if (cur.key==key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return -1;
    }

    private double doLoadFactor() {
        return usedSize*1.0 / array.length;
    }
}
