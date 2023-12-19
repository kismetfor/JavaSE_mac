class Dog{
    int age;
    public String color;
    public String name;
    public void barks() {
        System.out.println(name+"汪汪汪");
    }
    public void wag() {
        System.out.println(name+"摇尾巴");
    }
}
public class Main3 {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.name = "阿黄";
        dog1.color = "紫色";
        dog1.age = 12;
        dog1.wag();
        dog1.barks();
    }
}
