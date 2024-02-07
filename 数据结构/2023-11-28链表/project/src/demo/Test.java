package demo;

public class Test {
    /*public static mySingleList.ListNode mergeTwoLists(mySingleList.ListNode list1, mySingleList.ListNode list2) {
        mySingleList.ListNode newHead = new mySingleList.ListNode(-1);
        mySingleList.ListNode cur = newHead;
        while (list1!= null && list2!=null) {
            if(list1.val<list2.val) {
                cur.next = list1;
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
                cur = cur.next;
            }
        }
        if (list1!=null) {
            cur.next = list1;
        }
        if (list2 !=null){
            cur.next = list2;
        }
        return newHead.next;
    }*/
    public static void main(String[] args) {
        /*mySingleList mySingleList11 = new mySingleList();
        mySingleList11.addLast(1);
        mySingleList11.addLast(2);
        mySingleList11.addLast(4);
        mySingleList11.display();
        System.out.println();

        mySingleList mySingleList22 = new mySingleList();
        mySingleList22.addLast(1);
        mySingleList22.addLast(3);
        mySingleList22.addLast(4);
        mySingleList22.display();
        System.out.println();

        mySingleList.ListNode ret = mergeTwoLists(mySingleList11.head, mySingleList22.head);
        System.out.println();


*/
        mySingleList mySingleList = new mySingleList();
        mySingleList.creatList();
        mySingleList.display();
        System.out.println();
        System.out.println("=====remove");
        mySingleList.remove(56);
        mySingleList.display();

        System.out.println();
        System.out.println("=====addFirst");
        mySingleList.addFirst(21);
        mySingleList.display();

        System.out.println();
        System.out.println("=====addLast");
        mySingleList.addLast(67);
        mySingleList.display();

        System.out.println();
        System.out.println("=====addIndex");
        mySingleList.addIndex(3, 33);
        mySingleList.display();

/*        System.out.println();
        System.out.println("=====addIndex: 不合法Index示例");
        mySingleList.addIndex(99, 33);*/

        System.out.println();
        System.out.println("=====remove");
        mySingleList.remove(33);
        mySingleList.display();
        System.out.println();

        System.out.println("=====removeAllKey");
        mySingleList.addIndex(3, 33);
        mySingleList.addIndex(3, 33);
        mySingleList.addFirst(21);
        mySingleList.addFirst(21);
        mySingleList.display();
        System.out.println();
        mySingleList.removeAllKey(21);
        mySingleList.display();

        System.out.println();
        System.out.println("=====size");
        System.out.print(mySingleList.size());



    }
}
