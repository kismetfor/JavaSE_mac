package LinkedList与链表;

public class Main2 {
    public static ListNode reverseList(ListNode head) {
        //空链表或者只有一个节点
        if (head==null || head.next==null) return head;
        //链表两个节点
        if (head.next.next == null) {
            ListNode node = head.next;
            node.next = head;
            head.next = null;
            return node;
        }

        ListNode preNode = head;
        ListNode curNode = preNode.next;
        ListNode nextNode = curNode.next;
        head.next = null;
        while (nextNode != null) {
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
            nextNode = nextNode.next;
        }
        //处理尾巴tail
        curNode.next = preNode;
        return curNode;
    }
}
