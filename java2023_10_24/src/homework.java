public class homework {
    public static void main(String[] args) {
        byte a = 130;
        float b = 3.5f;
    }
    public static void main2(String[] args) {
//        经过强制类型转换以后，变量a，b的值分别为多少（    ）
//
//        short a =128；
//
//        byte b =(byte) a；
        short a =128; //2字节 0000 0000 1000 0000 128 = 2^7
        byte b =(byte) a; //1字节 1000 0000 就是补码形式的-0
        System.out.println(a);
        System.out.println(b);
    }
    public static void main1(String[] args) {
        //如果要打印一个字符串,需要使其输出结果为：\"hello\"，则以下哪种方式可以正确输出：( )
        System.out.println("\\\"hello\\\"");
    }
}
