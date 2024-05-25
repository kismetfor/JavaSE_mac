package LinkedList与链表;

public class Main3 {
    //链表的中间结点
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = initializeList3();
        ListNode node = middleNode(head);
        System.out.println(node.val);
        System.out.println();
    }
    public static ListNode initializeList3() {
        // 创建链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
//        ListNode node6 = new ListNode(6);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;

        // 返回头节点
        return node1;
    }
}
