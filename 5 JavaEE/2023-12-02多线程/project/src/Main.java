class MyBlockingQueue {
    private Object locker = new Object();
    private int size;
    private int head;
    private int tail;
    private String[] elems = null;
    public MyBlockingQueue (int capacity) {
        elems = new String[capacity];
    }
    public void put(String elem) {
        if (size >= elems.length) return;
        size++;
        elems[tail] = elem;
        tail++;
        if (tail >= elems.length) tail=0;
    }

    public String take() {
        if (size==0) return null;
        String h = elems[head];
        head++;
        if (head >= elems.length) head=0;
        return h;
    }


}
public class Main {
    public static void main(String[] args) {
        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(2);
        myBlockingQueue.put("qwe");
        myBlockingQueue.put("qwee");
        myBlockingQueue.put("qweee");
        myBlockingQueue.put("qweeett");

        for (int i = 0; i < 3; i++) {
            String elem;
            elem = myBlockingQueue.take();
            System.out.println(elem+" ");
        }

    }
}
