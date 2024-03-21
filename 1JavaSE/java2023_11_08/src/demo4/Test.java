package demo4;

class Shape {
    public void draw() {
        System.out.println("画图形! ");
    }
}
class Cycle extends Shape {
    @Override
    public void draw() {
        System.out.println("○");
    }
}
class Rect extends Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}
class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("三角形");
    }
}

public class Test {
    public static void drawMap(Shape shape){
        shape.draw();
    }
    public static void main(String[] args) {
        drawMap(new Rect());
        drawMap(new Cycle());
        drawMap(new Triangle());
        drawMap(new Shape());
    }
}
