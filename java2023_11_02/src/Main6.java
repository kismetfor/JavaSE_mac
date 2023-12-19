class Dogg {
    int age;
    String color;
    String name;
    public void bark() {
        System.out.println(name+"汪汪汪");
    }
    public void wag() {
        System.out.println(name+"摇尾巴");
    }
}

public class Main6 {
    public static void main(String[] args) {
        Dogg dog1 = new Dogg();
        dog1.age = 9;
        dog1.name = "小白";
        dog1.color = "黑色";
        System.out.println(dog1.name);
        dog1.bark();
        dog1.wag();

        Dogg dog2 = null;
    }
}
