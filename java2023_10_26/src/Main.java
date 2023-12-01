public class Main {
    public static void main(String[] args) {
        // 求a和b的平均值
        int a = 10;
        int b = 20;
        int c = a + ((b - a) >> 1);
        System.out.println(c);
    }
    public static void main8(String[] args) {
        // 求a和b的平均值
        int a = 10;
        int b = 20;
        int c = a + (b - a) >> 1;
        System.out.println(c);
    }
    public static void main7(String[] args) {
        int a = 10;
        int b = 20;
        //int c = a > b? 1 : 2.0;
    }
    public static void main6(String[] args) {
        int a = 0x10;
        System.out.printf("%x\n", a<<1);
        System.out.printf("%x\n", a);
    }
    public static void main5(String[] args) {
        System.out.println(1+0.2);
    }
    public static void main4(String[] args) {
        System.out.println(10.5%2);
    }
    public static void main3(String[] args) {
        int a = 1;
        int b = 0;
        System.out.println(a / b);
    }
    public static void main2(String[] args) {
        int a = 3;
        int b = 2;
// 在数学中应该是1.5 但是在Java中输出结果为1 会向下取整，即小数点之后全部舍弃掉了
        System.out.println(a / b);
// 如果要得到数学中的结果，可以使用如下方式
        double d = a*1.0 / b;
        System.out.println(d);
    }
    public static void main1(String[] args) {
        int a = 20;
        int b = 10;
        System.out.println(a + b); // 30
        System.out.println(a - b); // 10
        System.out.println(a * b); // 200
        System.out.println(a / b); // 2
        System.out.println(a % b); // 0 --->模运算相当于数学中除法的余数
    }
}
