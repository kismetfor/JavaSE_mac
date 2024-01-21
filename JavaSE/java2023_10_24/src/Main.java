public class Main {
    public static void main(String[] args) {
        String str = "123";
        int val = Integer.parseInt(str);
        System.out.println(val);

        String str2 = String.valueOf(val);
        System.out.println(str2);

        String str3 = val + "";
        System.out.println(str3);

        String str4 = Integer.toString(val);
        System.out.println(str4);
    }
    public static void main17(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("a = " +( a + b));
        System.out.println(a+b+"==a+b");
    }
    public static void main16(String[] args) {
        String str1 = "hello ";
        String str2 = "world";
        String str3 = str1 + str2;

        System.out.println(str3);
    }
    public static void main15(String[] args) {
        byte b1 = 10;
        byte b2 = 20;
        int b3 = b1 + b2;
    }
    public static void main14(String[] args) {
        int a = 10;
        long b = 10L;
        int c = (int)(a + b);
    }
    public static void main13(String[] args) {
        System.out.println(1024); // 整型默认情况下是int
        System.out.println(3.14); // 浮点型默认情况下是double

    }
    public static void main12(String[] args) {
        int a = 10;
        long b = 100L;
        a = (int)b;

    }
    public static void main11(String[] args) {
        int a = 10;
        long b = 100L;
        b = a; // 可以通过编译
//        a = b; // 编译失败
    }
    public static void main10(String[] args) {
        boolean a = true;
        System.out.println(a);
    }
    public static void main9(String[] args) {
        char ch = '赣';
        System.out.println(ch);
    }
    public static void main8(String[] argsR) {
        double dd = 1.1;
        System.out.println(dd*dd);
    }
    public static void main7(String[] args) {
        double a = 10.5;
        System.out.println(a);
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);

    }
    public static void main6(String[] args) {
        float a = 12.5f;
        System.out.println(a);
        System.out.println(Float.MIN_VALUE);
        System.out.println(Float.MAX_VALUE);

    }
    public static void main5(String[] args) {
        byte a = 10;
        System.out.println(a);
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);
    }
    public static void main4(String[] args) {
        short a = 19;
        System.out.println(a);
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);
    }
    public static void main3(String[] args) {
        long a = 10L;
        System.out.println(a);
    }
    public static void main2(String[] args) {
        int a = 10;
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    public static void main1(String[] args) {
        System.out.println("HelloWorld");
        System.out.println("A");
        System.out.println(100);
        System.out.println(3.14);
        System.out.println(true);
        System.out.println(false);

    }
}