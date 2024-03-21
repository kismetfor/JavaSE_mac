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
    /**
     * 出队
     */
    public int poll (){
        if (head==null) {
            return -1;
        }
        if (head.next == null) {
            head=null;
            last=null;
            return -1;
        }
        int ret = head.val;
        head = head.next;
        return ret;
    }
    public boolean empty() {
        return head==null;
    }

    /**
     * 取队头
     * @return
     */
    public int peek() {
        if (head==null) {
            return -1;
        }
        return head.val;
    }


}
