package demo2;

abstract class Shape {
    abstract public void draw();
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }
}

public class Test {
    public static void fun(Shape shape) {
        shape.draw();
    }
    public static void main(String[] args) {
        fun(new Rect());
        fun(new Cycle());
    }
}
