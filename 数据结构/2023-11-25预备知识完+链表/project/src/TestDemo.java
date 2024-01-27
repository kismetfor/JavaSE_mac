import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class TestDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList.isEmpty());
    }
    public static void main4(String[] args) {
        String s1 = "welcome to cvte";
        String s2 = "come";
        ArrayList<Character> characters = new ArrayList<>();
//        for (int i = 0; i < s1.length(); i++) {
//            int flag = 0;
//            for (int j = 0; j < s2.length(); j++) {
//                if (s2.charAt(j) == s1.charAt(i)) {
//                    flag++;
//                    break;
//                }
//            }
//            if (flag==0) {
//                characters.add(s1.charAt(i));
//            }
//        }
        for (int i = 0; i < s1.length(); i++) {
            char ch = s1.charAt(i);
            if (!s2.contains(ch+"")){
                characters.add(ch);
            }
        }
        for (char x:
             characters) {
            System.out.print(x);
        }
    }
    public static void main3(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);

        List<Integer> list = arrayList.subList(0, 3);
        list.set(0, 99);
        System.out.println(arrayList);
        for (Integer x:arrayList
             ) {
            System.out.print(x + " ");
        }
        System.out.println();
        //迭代器遍历
        Iterator<Integer> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("迭代器2");
        //迭代器2
        ListIterator<Integer> iterator1 = arrayList.listIterator();
        while (iterator1.hasNext()) {
            System.out.print(iterator1.next() + " ");
        }
        System.out.println();
        System.out.println("从后往前打印");
        //从后往前打印
        ListIterator<Integer> iterator2 = arrayList.listIterator(arrayList.size());
        while (iterator2.hasPrevious()) {
            System.out.print(iterator2.previous()+" ");
        }
        System.out.println();
    }
    public static void main2(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(1);
    }
    public static void main1(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);

        System.out.println(myArrayList.contains(5));
        System.out.println(myArrayList.indexOf(2));

        myArrayList.remove(3);
        myArrayList.display();
    }
}