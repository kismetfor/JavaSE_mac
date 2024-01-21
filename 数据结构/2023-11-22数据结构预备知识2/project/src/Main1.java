public class Main1 {
    public static void main(String[] args) {
        Integer ii = 200;
        Integer ii2 = 200;
        System.out.println(ii == ii2);
    }
    public static void main1(String[] args) {
        int a = 1;
        //Integer ii = a; //自动装箱
        Integer ii = Integer.valueOf(a);
//        Integer ii2 = new Integer(2);
        Integer ii2 = Integer.valueOf(2);
        int b = ii2; //自动拆箱
        System.out.println(a);
        System.out.println(b);
    }
}
