package LinkedList与链表;

public class Main6 {
    public static void main(String[] args) {
        ListNode head = initializeList6();
        System.out.println(chkPalindrome(head));
    }
    public static boolean chkPalindrome(ListNode A) {
        if (A==null) return false;
        //中间节点 奇数往后一个 偶数不变
        ListNode head = A;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prevNode = null;
        if (fast == null) {
            //偶数个
            prevNode = slow;
        } else {
            //奇数
            prevNode = slow.next;
        }

        //反转链表
        ListNode node = prevNode.next;
        ListNode nextNode = node.next;
        prevNode.next = null;

        while (true) {
            node.next = prevNode;
            if (nextNode == null) break;
            nextNode = nextNode.next;
            prevNode = node;
            node = nextNode;
        }

        //比较是否相同
        while (node != null) {
            if (node.val != head.val) return false;
            node = node.next;
            head = head.next;
        }
        return true;
    }
    public static ListNode initializeList6() {
        //(559，526,134，568,197,532）
        // 创建链表节点
        /*ListNode node1 = new ListNode(559);
        ListNode node2 = new ListNode(526);
        ListNode node3 = new ListNode(134);
        ListNode node4 = new ListNode(568);
        ListNode node5 = new ListNode(532);*/

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

//        ListNode node6 = new ListNode(6);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;

        // 返回头节点
        return node1;
    }
}
