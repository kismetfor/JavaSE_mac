package LinkedList与链表;

public class Main9 {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        slow = head;
        while (true) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) return slow;
        }

    }
}
