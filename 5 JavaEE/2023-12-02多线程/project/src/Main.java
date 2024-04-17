class MyBlockingQueue {
    private Object locker = new Object();
    private int size;
    private int head;
    private int tail;
    private String[] elems = null;
    public MyBlockingQueue (int capacity) {
        elems = new String[capacity];
    }
    public void put(String elem) throws InterruptedException {
        synchronized (locker) {
            while (size >= elems.length){
                locker.wait();
            }
            size++;
            elems[tail] = elem;
            tail++;
            if (tail >= elems.length) tail=0;
            locker.notify();
        }
    }

    public String take() throws InterruptedException {
        String h = null;
        synchronized (locker) {
            while (size==0) {
                locker.wait();
            }
            h = elems[head];
            head++;size--;
            if (head >= elems.length) head=0;
            locker.notify();
        }
        return h;
    }


}
public class Main {
    public static void main(String[] args) {
        MyBlockingQueue queue = new MyBlockingQueue(2);

        Thread producer = new Thread(()->{
            int n = 0;
            while (true) {
                try {
                    System.out.println("生产者生产元素"+n);
                    queue.put(Integer.toString(n));
                    n++;

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });
        Thread conductor = new Thread(()->{
            while (true) {
                try {
                    System.out.println("消费者消费元素"+queue.take());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

        });

        producer.start();
        conductor.start();
    }
    public static void main1(String[] args) throws InterruptedException {

        MyBlockingQueue myBlockingQueue = new MyBlockingQueue(2);



        Thread t1 = new Thread(()->{
            try {
                myBlockingQueue.put("001");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                myBlockingQueue.put("002");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(()->{
            try {
                myBlockingQueue.put("003");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                myBlockingQueue.put("004");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

       Thread t3 = new Thread(()->{
           for (int i = 0; i < 5; i++) {
               String elem;
               try {
                   elem = myBlockingQueue.take();
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println(elem+" ");
           }
       });
       t1.start();
       t2.start();
       t3.start();

    }
}
