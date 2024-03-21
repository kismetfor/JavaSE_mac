/**
 * 测试removeAllKey
 */
/*


public class mySingleList{
    ListNode head = null;
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
        ListNode node5 = new ListNode(56);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        this.head = node1;
    }
    public void addIndex(int index, int data) {
        ListNode prev = head;
        while (--index!=0) {
            prev = prev.next;
        }
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;
    }

public void removeAllKey(int key) {
        ListNode prev = head;
        ListNode cur = prev.next;
        while (cur.next!=null) {
            if (cur.val==key) {
                prev.next = cur.next;
                cur = prev.next;
            }
            else {
                cur = cur.next;
                prev = cur;
            }
        }
    }
    public static void main(String[] args) {
        mySingleList mySingleList = new mySingleList();
        mySingleList.creatList();
        mySingleList.addIndex(3, 33);
        mySingleList.addIndex(3, 33);
        mySingleList.removeAllKey(33);

    }
}

 */