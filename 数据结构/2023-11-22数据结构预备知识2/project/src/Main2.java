public class Main2 {
    public static void main(String[] args) {
        int a = 1;
        Integer i = a;
        //自动装箱
        int b = i;
        //自动拆箱

        Integer ii = Integer.valueOf(a);
        //手动装箱
        int bb = ii.intValue();
        //手动拆箱

    }
}
