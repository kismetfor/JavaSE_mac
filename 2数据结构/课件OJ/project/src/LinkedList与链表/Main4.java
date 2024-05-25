package LinkedList与链表;

public class Main4 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode nextNode1 = list1.next;
        ListNode nextNode2 = list2.next;
        ListNode head = null;

        while (nextNode2!=null && nextNode1!=null) {
            if (list1.val <= list2.val) {
                if (head == null) head = list1;
                list1.next = list2;
                list2.next = nextNode1;
                list1 = nextNode1;
                list2 = nextNode2;
            } else {
                if (head == null) head = list2;
                list2.next = list1;
                list1.next = nextNode2;
                list1 = nextNode1;
                list2 = nextNode2;
            }

        }

        return head;
    }
}
