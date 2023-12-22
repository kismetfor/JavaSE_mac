public class Main1 {

    public static void main(String[] args) {
        Dog dog = new Dog("旺财", 10, "白色");
        System.out.println("===========");
        Dog dog2 = new Dog("旺财", 10, "白色");
        //静态的只执行一次 父类的实例>>父类的构造>>子类的实例>>子类的构造
    }
}
