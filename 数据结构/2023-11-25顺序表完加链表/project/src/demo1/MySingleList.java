package demo1;

import java.util.List;

public class MySingleList implements IList {
    ListNode head; //null

    class ListNode {
        int val;
        ListNode next;


        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }

    }
    public void creatList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        this.head = node1;
    }
    @Override
    public void addFirst(int data) {

    }

    @Override
    public void addLast(int data) {

    }

    @Override
    public void dataIndex(int index, int data) {

    }

    @Override
    public boolean contains(int ksy) {
        return false;
    }

    @Override
    public void remove(int key) {

    }

    @Override
    public void removeAllKsy(int key) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {

    }

}
