package demo3;

/*
1.定义接口的时候使用关键字interface来定义
2.接口当中的方法如果没有被实现，那么他默认就是一个抽象方法。
3.接口当中的方法不能有具体的实现
4.如果要有具体的实现，那么必须是由default修饰或者是由static修饰
5.接口当中定义成员变量默认都是public static final的
6.接口当中的抽象方法默认都是public abstract修饰的
7.接口是不可以被实例化的
8.类和接口之间的关系可以使用implements来关联
9.接口也是可以产生字节码文件的 .class文件
 */

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.powerON();
        computer.useDevice(new Mouse());
        computer.useDevice(new KeyBoard());
        computer.powerOff();
    }
}
