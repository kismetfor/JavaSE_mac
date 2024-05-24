package LinkedList与链表;

public class Main1 {

    public static ListNode removeElements(ListNode head, int val) {
        //头结点为空
        if (head==null) return null;
        //头结点全为val时
        while (head.val==val) {
            head = head.next;
            if (head == null) return null;
        }
        ListNode preNode = head;
        //只有一个头结点时
        if (head.next == null) return head;
        ListNode curNode = preNode.next;
        ListNode nextNode = curNode.next;
        while (curNode.next != null) {
            if (curNode.val==val) {
                preNode.next = nextNode;
            } else {
                preNode = curNode;
            }
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        //单独处理尾巴
        if (curNode.val==val) preNode.next = null;
        return head;
    }

    public static void main(String[] args) {
//        ListNode head = initializeList1();
//        removeElements(head, 6);
        ListNode head = initializeList2();
        removeElements(head, 7);
        System.out.println();

    }
    public static ListNode initializeList1() {
        // 创建链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;

        // 返回头节点
        return node1;
    }
    public static ListNode initializeList2() {
        // 创建链表节点
        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(7);
        ListNode node4 = new ListNode(7);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // 返回头节点
        return node1;
    }
}
