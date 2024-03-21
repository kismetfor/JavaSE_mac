class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Main3 {
    //由于双指针快乐数已经写过了 这里就写一道类似的题目
    public boolean hasCycle(ListNode head) {
        if (head==null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null&&fast.next!=null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow==fast) {
                return true;
            }
        }
        return false;
    }
}
