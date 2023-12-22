class Base {
    public int a = 1;
    public int b = 2;
    public int z = 100;
    public void father() {
        System.out.println("father");
    }
    public void test(int z) {
        System.out.println(z);
    }
}
class Derived extends Base {
    public int a = 3;
    public int c = 4;
    public int z = 99;
    public void method() {
        System.out.println(super.a);
        System.out.println(this.a);
        System.out.println(super.b);
        System.out.println(this.b);
        System.out.println(this.c);
//        System.out.println(super.c);
    }
    public void son(){
        System.out.println("SON");
        father();
    }
    public void test() {
        System.out.println(z);
    }
}

public class Test2 {


    public static void main(String[] args) {
        Derived d = new Derived();
        d.test(10);
    }
}
