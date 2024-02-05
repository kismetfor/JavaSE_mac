package demo;

public class mySingleList implements IList{
    ListNode head = null;
    public void creatList() {
        ListNode node1 = new ListNode(12);
        ListNode node2 = new ListNode(23);
        ListNode node3 = new ListNode(34);
        ListNode node4 = new ListNode(45);
        ListNode node5 = new ListNode(56);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        this.head = node1;
    }

    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = head;
        head = node;
    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    @Override
    public void addIndex(int index, int data) {
        if (index<0 || index >size()) {
            throw new indexException("index位置不合法: "+index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index==size()) {
            addLast(data);
            return;
        }
        ListNode prev = head;
        while (--index!=0) {
            prev = prev.next;
        }
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
    }

    @Override
    public boolean contains(int key) {
        return false;
    }

    @Override
    public void remove(int key) {
        if (head==null){
            return;
        }
        if (head.val==key){
            head.next = head;
            return;
        }
        ListNode node = findPrevKey(key);
        node.next = node.next.next;
    }
    public ListNode findPrevKey(int key) {
        ListNode node = head;
        while (node.next != null) {
            if (node.next.val == key) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    @Override
    public void removeAllKey(int key) {
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur != null) {
//        while (cur.next!=null) {
            if (cur.val==key) {
                prev.next = cur.next;
                cur = prev.next;
            }
            else {
                prev = cur;
                cur = cur.next;
            }
        }
        //头结点的判断 如果放前面就不能全删掉 放最后面就OK滴
        if (head.val==key) {
            head = head.next;
        }
        /*
        //补上最后一个的判断
        if (cur.val==key) {
            prev.next = cur.next;
            cur = prev.next;
        }
        */
    }

    @Override
    public int size() {
        ListNode node = head;
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
        ListNode node = head;
        while (node != null) {
            System.out.print(node.val+" ");
            node = node.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
