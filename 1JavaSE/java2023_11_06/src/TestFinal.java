//final叫做 密封类 代表当前类是不可以被继承的
/*final */class Person{

}
class Boy extends Person{

}
class Student2 {

}
class Teacher {

}
class School {
    public Student2[] student2s = new Student2[12];
    public Teacher[] teachers = new Teacher[12];
    //组合

}


public class TestFinal {
    public static void main(String[] args) {
        final int a = 20; //a是常量
        // a = 10;
        System.out.println(a);
        int[] arr = new int[10];
    }
}
