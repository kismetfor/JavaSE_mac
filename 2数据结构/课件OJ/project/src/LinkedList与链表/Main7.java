package LinkedList与链表;

public class Main7 {
    public static void main(String[] args) {
        ListNode headA = initializeListA();
        ListNode headB = initializeListB();
        ListNode node = getIntersectionNode(headA, headB);

        System.out.println(node.val);
    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB==null) return null;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        int lengthA = 0;
        int lengthB = 0;
        while (nodeA != null && nodeB != null) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            lengthA++;lengthB++;
        }
        if (nodeA == null) {
            while (nodeB != null) {
                lengthB++;
                nodeB = nodeB.next;
            }
        } else if (nodeB == null){
            while (nodeA != null) {
                lengthA++;
                nodeA = nodeA.next;
            }
        }

        if (lengthA > lengthB) {
            int tmp = lengthA - lengthB;
            while (tmp-- != 0) {
                headA = headA.next;
            }
        } else if (lengthA < lengthB) {
            int tmp = lengthB - lengthA;
            while (tmp-- != 0) {
                headB = headB.next;
            }
        }
        while (true) {
            if (headA.val == headB.val) {
                return headA;
            }
            if (headA.next == null || headB.next == null) return null;
            headA = headA.next;
            headB = headB.next;
        }
    }
    public static ListNode initializeListB() {
        // 创建链表节点
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(6);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(8);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        // 返回头节点
        return node1;
    }
    public static ListNode initializeListA() {
        // 创建链表节点
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // 返回头节点
        return node1;
    }
}
