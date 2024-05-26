package LinkedList与链表;

public class Main8 {
    /**
     * 做题教训:
     * 要检查 fast.next == null
     * 必须先检查fast 是否为 null
     * @param args
     */
    public static void main(String[] args) {
        ListNode node = initializeListHead();
        hasCycle(node);

    }
    public static boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;

        while (true) {
            if (fast == null || fast.next == null) return false;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }

        slow = head;
        while (true) {
            fast = fast.next;
            slow = slow.next;
            if (fast == slow) return true;
        }

    }
    public static ListNode initializeListHead() {
        // 创建链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        // 连接链表节点
        node1.next = node2;

        // 返回头节点
        return node1;
    }

}
