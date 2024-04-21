import java.util.concurrent.CopyOnWriteArrayList;

public class Main6 {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        list.add(1, "D");

        for(String s : list) {
            System.out.print(s+" ");
        }
    }
}
