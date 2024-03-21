package demo1;

public class Test {
    public static void main(String[] args) {
        myLinkedList list = new myLinkedList();
        list.offer(1);
        list.offer(2);
        list.offer(3);
        list.offer(4);

        System.out.println(list.poll());
        System.out.println(list.peek());
    }
}
