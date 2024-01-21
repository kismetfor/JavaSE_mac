package demo3多态;

public class Test {
    public static void main(String[] args) {
        Dog d = new Dog("旺财", 2, "白色");
        d.eat();
        d.barks();

        //父类引用 引用了子类对象
        //向上转型
        Animal a = new Dog("动物", 3, "黄色");
        a.eat();
    }
}
