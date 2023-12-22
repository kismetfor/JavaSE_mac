public class Dog extends Animal{
    static {
        System.out.println("Dog::Static");
    }
    {
        System.out.println("Dog::{  }");
    }

    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
        System.out.println("Dog::String name, int age, String color");
    }

    public String color;
    public void bark() {
        System.out.println(this.name+" 汪汪汪......");
    }
    public static void main(String[] args) {
        Dog d = new Dog("小黄", 2, "灰色");
        d.bark();
    }
}
