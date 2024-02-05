package demo1;

import java.util.List;

public class MySingleList implements IList {
    ListNode head; //null

    static class ListNode {
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
        //插入数据的时候 一定先绑后面
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
        } else {
            ListNode cur = this.head;
            while (cur.next != null ) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            throw new IndexException("Index位置不合法: "+index);
        }
        ListNode node  = new ListNode(data);
        if (this.head==null) {
            node = this.head;
        }
        if (index==0){
            addFirst(data);
            return;
        }
        if (index==size()){
            addLast(data);
            return;
        }
        ListNode cur = searchPervNode(index);
        node.next = cur.next;
        cur.next = node;
    }

    /**
     * 找Index前面一个位置的节点
     */
    private ListNode searchPervNode(int index) {
        ListNode cur = this.head;
        while (--index != 0) {
            cur = cur.next;
        }
        return cur;
    }
    /**
     * 求当前链表是否存在Key
     * @param key
     * @return
     */
    @Override
    public boolean contains(int key) {
        ListNode node = head;
        while (node != null) {
            if (node.val == key) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        if (this.head.val==key) {
            this.head = this.head.next;
            return;
        }
        ListNode node = this.head;
        while (node.next != null) {
            if (node.next.val == key) {
                node.next = node.next.next;
                return;
            } else {
                node = node.next;
            }
        }
    }

    @Override
    public void removeAllKsy(int key) {

    }

    /**
     * 求当前链表有多少个节点
     * @return
     */
    @Override
    public int size() {
        ListNode node = this.head;
        int ret = 0;
        while (node != null) {
            ret++;
            node = node.next;
        }
        return ret;
    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {
        ListNode node = this.head;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

}
