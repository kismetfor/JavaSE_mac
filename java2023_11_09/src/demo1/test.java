package demo1;

abstract class Shape {
    public abstract void draw();
    //不能在定义好后能够真正地表示一个具体的对象
}

class Rect extends Shape {
    //普通类继承抽象类必须重写抽象方法
    @Override
    public void draw() {
        System.out.println("画矩形");
    }
}
class Cycle extends Shape {
    //普通类继承抽象类必须重写抽象方法
    @Override
    public void draw() {
        System.out.println("画圆圈");
    }
}
class Flower extends Shape {
    //普通类继承抽象类必须重写抽象方法
    @Override
    public void draw() {
        System.out.println("画花儿");
    }
}
public class test {
    public static void fun(Shape shape) {
        shape.draw();
        //发生多态
    }
    public static void main(String[] args) {
        fun(new Cycle());
        fun(new Rect());
        fun(new Flower());
    }
}
