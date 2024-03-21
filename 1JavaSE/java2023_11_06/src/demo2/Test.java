package demo2;

import demo1.TestDemo1;

public class Test extends TestDemo1 {
    public void func() {
        System.out.println(super.a);
        //protected
        //不同包 子类 可访问
        //不同包 非子类 不可访问
    }

    public static void main(String[] args) {
        TestDemo1 t = new TestDemo1();
//        System.out.println(t.a);
        //java: a 在 demo1.TestDemo1 中是 protected 访问控制
    }
}
