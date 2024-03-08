package demo2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        Set<String> set = new HashSet<>();

        HashMap<String, Integer> map2 = new HashMap<>();
    }
    public static void main2(String[] args) {
        Student student = new Student("123456");
        System.out.println(student.hashCode());

        Student student1 = new Student("123456");
        System.out.println(student1.hashCode());

        System.out.println("====");

        HashBuck2 hashBuck2 = new HashBuck2();
        hashBuck2.push(student, 123);
        System.out.println(hashBuck2.get(student1));

    }
    public static void main1(String[] args) {
        HashBuck hashBuck = new HashBuck();
        hashBuck.push(1, 10);
        hashBuck.push(2, 20);
        hashBuck.push(2, 200);
        hashBuck.push(3, 30);
        hashBuck.push(4, 40);
        hashBuck.push(5, 50);
        hashBuck.push(6, 60);
        hashBuck.push(7, 70);
        hashBuck.push(8, 80);
        hashBuck.push(9, 90);
        hashBuck.push(10, 100);
        hashBuck.push(11, 110);
        hashBuck.push(12, 110);
        hashBuck.push(13, 110);
        hashBuck.push(111, 110);
        hashBuck.push(112, 110);
        hashBuck.push(113, 110);
        hashBuck.push(114, 110);
        System.out.println(hashBuck.array.length);
        System.out.println(hashBuck.get(7));
        System.out.println(hashBuck.get(155));
    }
}
