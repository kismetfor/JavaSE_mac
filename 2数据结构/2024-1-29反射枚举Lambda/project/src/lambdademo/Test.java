package lambdademo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @Author 12629
 * @Description：
 */
//无返回值无参数================================
@FunctionalInterface
interface NoParameterNoReturn {
    void test();
}
//无返回值一个参数
@FunctionalInterface
interface OneParameterNoReturn {
    void test(int a);
}
//无返回值多个参数
@FunctionalInterface
interface MoreParameterNoReturn {
    void test(double a,int b);
}

//有返回值无参数
@FunctionalInterface
interface NoParameterReturn {
    int test();
}
//有返回值一个参数
@FunctionalInterface
interface OneParameterReturn {
    int test(int a);
}

//有返回值多参数
@FunctionalInterface
interface MoreParameterReturn {
    int test(int a,int b);
}
public class Test {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("int", 3);
        map.put("main", 4);
        map.put("zhangyuxiao", 9);
        map.forEach((s, Integer)-> System.out.println("key: "+s+" val: " + Integer));
    }
    public static void main3(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        list.add("bit");
        list.add("lambda");
        list.forEach(s-> System.out.println(s));
        list.sort((o1,o2)->o1.compareTo(o2));
        System.out.println();
        list.forEach(s-> System.out.println(s));
    }
    public static void main2(String[] args) {
        NoParameterNoReturn noParameterNoReturn = ()-> System.out.println("test()...");
        noParameterNoReturn.test();
//        OneParameterReturn oneParameterReturn = (a) -> System.out.println(a+1);
//        oneParameterReturn.test(10);
    }
    public static void main1(String[] args) {
        NoParameterNoReturn noParameterNoReturn = new NoParameterNoReturn() {
            @Override
            public void test() {
                System.out.println("test...");
            }
        } ;
        noParameterNoReturn.test();

    }
}
