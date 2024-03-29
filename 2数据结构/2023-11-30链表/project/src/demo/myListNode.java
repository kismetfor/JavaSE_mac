package demo;

public class myListNode {
    public static class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void creatList() {
        ListNode node1 = new ListNode(14);
        ListNode node2 = new ListNode(32);
        ListNode node3 = new ListNode(12);
        ListNode node4 = new ListNode(44);
        ListNode node5 = new ListNode(56);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
    }

    /**
     * OR36 链表的回文结构
     * https://www.nowcoder.com/practice/d281619e4b3e4a60a2cc66ea32855bfa?tpId=49&&tqId=29370&rp=1&ru=/activity/oj&qru=/ta/2016test/question-ranking
     * @param A
     * @return
     */
    public static boolean chkPalindrome(ListNode A) {
        if(A==null){
            return false;
        }
        ListNode pHead = A;
        ListNode slow = A;
        while (A != null && A.next != null) {
            A = A.next.next;
            slow = slow.next;
        }
        ListNode cur = slow.next;
        slow.next = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (slow != null) {
            if (pHead.val != slow.val) {
                return false;
            }
            pHead = pHead.next;
            slow = slow.next;
        }
        return true;
    }



    public static void display(ListNode pHead) {
        while (pHead != null) {
            System.out.print(pHead.val+" ");
            pHead = pHead.next;
        }
    }
        public static ListNode partition(ListNode pHead, int x) {
        if (pHead==null || pHead.next==null) {
            return pHead;
        }
            ListNode bs = null;
            ListNode be = null;
            ListNode as = null;
            ListNode ae = null;
            while (pHead != null) {
                        if (pHead.val < x) {
                            if (bs == null) { //区分第一次插入
                            bs = pHead;
                            be = bs;
                        } else {
                            be.next = pHead;
                            be = be.next;
                        }
                    } else {
                            if(as == null) {
                                as = pHead;
                                ae = as;
                            } else {
                                ae.next = pHead;
                                ae = ae.next;
                            }
                        }
                pHead = pHead.next;
            }
            if (bs==null) {
                return as;
            }
            if (ae!=null && ae.next != null){
                ae.next = null;
            }
            be.next = as;
            return bs;
        }
    }

