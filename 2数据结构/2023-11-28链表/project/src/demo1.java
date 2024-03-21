//
//
//public class mySingleList{
//    ListNode head = null;
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        public ListNode(int val) {
//            this.val = val;
//            this.next = null;
//        }
//    }
//    public void creatList() {
//        ListNode node1 = new ListNode(12);
//        ListNode node2 = new ListNode(23);
//        ListNode node3 = new ListNode(34);
//        ListNode node4 = new ListNode(45);
//        ListNode node5 = new ListNode(56);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        this.head = node1;
//    }
//
//    public void remove(int key) {
//        if (head==null){
//            return;
//        }
//        if (head.val==key){
//            head.next = head;
//            return;
//        }
//        ListNode node = findPrevKey(key);
//        node.next = node.next.next;
//    }
//    public ListNode findPrevKey(int key) {
//        ListNode node = head;
//        while (node.next != null) {
//            if (node.next.val == key) {
//                return node;
//            }
//            node = node.next;
//        }
//        return null;
//    }
//    public static void main(String[] args) {
//        mySingleList mySingleList = new mySingleList();
//        mySingleList.creatList();
//        mySingleList.remove(56);
//    }
//}