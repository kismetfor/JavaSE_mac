public class Animal {
    public String name;
    static {
        System.out.println("Animal::static");
        //无论什么 情况 静态的一定先执行
    }
    {
        System.out.println("Animal{  }");
        //父类的静态>>子类的静态>>父类的实例>>父类的构造>>子类的实例>>子类的构造
    }
    public int age;
    public void eat() {
        System.out.println(this.name+" 吃东西.......");
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("Animal(String name, int age)");
    }

    public static void main(String[] args) {

    }
}
