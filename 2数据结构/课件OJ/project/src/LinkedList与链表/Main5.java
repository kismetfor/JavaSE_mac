package LinkedList与链表;

public class Main5 {
    public static void main(String[] args) {
        ListNode node = initializeList6();
        ListNode head = partition(node, 3);
        while (head!=null) {
            System.out.print(head.val+" -> ");
            head = head.next;
        }
    }

    /**
     * 这道题忽略了 尾结点没有置为空 导致为循环链表
     * @param pHead
     * @param x
     * @return
     */
    public static ListNode partition(ListNode pHead, int x) {
        ListNode smallerNodeHead = null;
        ListNode smallerNodeTail = null;
        ListNode biggerNodeHead = null;
        ListNode biggerNodeTail = null;



        while (pHead != null) {
            if (pHead.val < x) {
                if (smallerNodeHead == null) {
                    smallerNodeHead = pHead;
                    smallerNodeTail = smallerNodeHead;
                } else {
                    smallerNodeTail.next = pHead;
                    smallerNodeTail = smallerNodeTail.next;
                }

            } else {
                if (biggerNodeHead == null) {
                    biggerNodeHead = pHead;
                    biggerNodeTail = biggerNodeHead;
                }else {
                    biggerNodeTail.next = pHead;
                    biggerNodeTail = biggerNodeTail.next;
                }
            }
            pHead = pHead.next;
        }

        if (biggerNodeTail != null) biggerNodeTail.next = null;
        if (smallerNodeTail!=null) {
            smallerNodeTail.next = biggerNodeHead;
            //正常情况
            return smallerNodeHead;
        }
        //全是比x大的
        return biggerNodeHead;
    }
    public static ListNode initializeList6() {
        // 创建链表节点
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);

        // 连接链表节点
        node1.next = node2;
        node2.next = node3;

        // 返回头节点
        return node1;
    }
}
