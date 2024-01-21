package demo5;

abstract class Shape {
    abstract public void draw();
    abstract void clacArea();
    public double getArea() {
        return area;
    }
    protected double area;
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("画矩形");
    }

    @Override
    void clacArea() {

    }
}
class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("三角形");
    }

    @Override
    void clacArea() {

    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("圆形");
    }

    @Override
    void clacArea() {

    }
}
public class Test {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        Shape s = new Cycle();
        Shape s1 = new Rect();
        drawMap(s);
        drawMap(s1);
    }
}
