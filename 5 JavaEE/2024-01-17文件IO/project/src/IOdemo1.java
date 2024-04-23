public class IOdemo1 {
    static void func3(String s) {
        s = "abc";
    }
    public static void main(String[] args) {


        String s = "还是";
        func3(s);
        System.out.println(s);
    }
}
