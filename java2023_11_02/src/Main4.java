class MyValue {
    int value;
}

public class Main4 {
    public static void swap(MyValue v1, MyValue v2) {
        int tmp = v1.value;
        v1.value = v2.value;
        v2.value = tmp;
    }

    public static void main(String[] args) {
        MyValue value1 = new MyValue();
        MyValue value2 = new MyValue();
        value1.value = 10;
        value2.value = 20;
        swap(value1, value2);
        System.out.println(value1.value);
        System.out.println(value2.value);
    }
}
