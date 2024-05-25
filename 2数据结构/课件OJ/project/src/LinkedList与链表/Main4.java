package LinkedList与链表;

public class Main4 {
    public static void main(String[] args) {
        ListNode list1 = initializeList4();
        ListNode list2 = initializeList5();
        ListNode head = mergeTwoLists(list1, list2);
        while (head != null) {
            System.out.print(head.val+ " -> ");
            head = head.next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode head = new ListNode(0);
        //尾结点
        ListNode node = null;

        //第一个节点
        if (list1.val <= list2.val) {
            head.next = list1;
            node = list1;
            list1 = list1.next;
        } else {
            head.next = list2;
            node = list2;
            list2 = list2.next;
        }
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            }else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        //处理末尾
        if (list1 == null) {
            node.next = list2;
        } else {
            node.next = list1;
        }
        return head.next;
    }
    public static ListNode initializeList4() {
        // 创建链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;

        // 返回头节点
        return node1;
    }
    public static ListNode initializeList5() {
        // 创建链表节点
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;

        // 返回头节点
        return node1;
    }
}
