package demo1;

public class myLinkedList {
    ListNode head;
    ListNode last;

    public static class ListNode{
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 入队
     * @param val
     */
    public void offer(int val) {
        ListNode node = new ListNode(val);
        if (head==null) {
            head = last = node;
            return;
        }
        last.next = node;
        node.prev = last;
        last = node;
    }
}
