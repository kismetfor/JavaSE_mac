public class Student {
    private String name;
    public int age;
    private void eat() {
        System.out.println(this.name+" 正在吃饭!");
    }

    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.age = 11;
        stu1.name = "小王";
        stu1.eat();
    }
}
