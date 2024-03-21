package demo3;

class B {
    public B() {
        func();
    }
    public void func() {
        System.out.println("B.func()");
    }
}
class D extends B {
    private int num = 1;
    public D() {
        super();
    }
    @Override
    public void func() {
        System.out.println("D.func()"+this.num);
    }
}
public class Test {
    public static void main(String[] args) {
        D d = new D();
    }
}
