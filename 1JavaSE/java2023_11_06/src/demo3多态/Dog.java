package demo3多态;

public class Dog extends Animal{
    public String color;

    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
    public void barks() {
        System.out.println(this.name+" wangwang");
    }
    public void eat() {
        System.out.println(this.name+"正在吃狗粮");
    }
}
