package demo1;

class Animal{
    public String name;
    public int age;
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void eat() {
        System.out.println(this.name+" 正在吃......");
    }
    public void bark(int age) {
        System.out.println(this.name+" 父类方法正在....");
    }
}
class Dog extends Animal{
    public String color;
    public Dog(String name, int age, String color) {
        super(name, age);
        this.color = color;
    }
    public void bark() {
        System.out.println(this.name+" 正在哇哇叫....");
    }
    public void eat() {
        System.out.println(this.name+" 正在吃狗粮....");
    }
    /*
    1.方法名相同
    2.参数列表相同【顺序、个数、类型】
    3.返回值相同
    1+2+3 = 重写
     */
}
class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    public void fly() {
        System.out.println(this.name+" 正在飞");
    }
    public void eat() {
        System.out.println(this.name+" 正在吃鸟粮");
    }
}
public class Test {
    public static void main(String[] args) {
        Animal animal1 = new Dog("小黄", 2, "黑色");
        if(animal1 instanceof Bird){
            Bird bird1 = (Bird)animal1;
            bird1.fly();
        }else {
            System.out.println("hello");
        }
        //向下转型
        Animal animal2 = new Bird("布谷", 2);
        if(animal2 instanceof Bird){
            Bird bird = (Bird)animal2;
            bird.fly();
        }

    }
    public static void fun(Animal animal){
        animal.eat();
    }
    public static Animal fun2() {
        return new Bird("布谷", 1);
        //父类声明返回值 子类返回值
    }

    public static void main4(String[] args) {
        fun2().eat();
    }
    public static void main3(String[] args) {
        /*
        向上转型：实际就是创建一个子类对象，将其当成父类对象来使用。
        语法格式：父类类型对象名=new子类类型()
         */
        //向上转型
        //直接赋值
        //传参
        //通过返回值
        Animal animal1 = new Dog("小黄", 2, "黑色");
        Bird animal2 = new Bird("布谷", 2);
        Animal bird = animal2;
        fun(animal1);
        fun(bird);
        /*
        同一个引用调用了同一个方法
        但是因为引用的对象不一样，所表现的行为不一样。
        我们把这种思想，称之为多态
         */

    }
    public static void main2(String[] args) {
        Animal a = new Dog("小花", 2, "黑色") ;
        a.bark(10);
        //父类引用只能调用父类的东西 不能调用子类的东西
        /*
        动态绑定
        编译的时候认为还是确实是调用了父类的eat方法
        运行的时候绑定到了子类当中
        静态绑定:编译的时候就已经确定我调用哪个方法了(比如有参数的情况下)
         */
    }
    public static void main1(String[] args) {
        Dog d = new Dog("小花", 2,"白色") ;
        d.eat();
        d.bark();
    }
}
