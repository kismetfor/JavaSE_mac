package demo;

public class Test {
    public static void main(String[] args) {
        myListNode myListNode = new myListNode();
        demo.myListNode.ListNode node1 = new myListNode.ListNode(23);
        demo.myListNode.ListNode node2 = new myListNode.ListNode(45);
        demo.myListNode.ListNode node3 = new myListNode.ListNode(6);
        demo.myListNode.ListNode node4 = new myListNode.ListNode(2);
        demo.myListNode.ListNode node5 = new myListNode.ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        demo.myListNode.display(node1);
        System.out.println();

        demo.myListNode.ListNode node = demo.myListNode.partition(node3, 9);


        demo.myListNode.display(node);
        System.out.println();
    }


}
