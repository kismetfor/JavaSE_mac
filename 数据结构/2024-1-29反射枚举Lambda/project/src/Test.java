/**
 * @Author 12629
 * @Description：
 */
class Student {
    //私有属性name
    private String name = "bit";
    //公有属性age
    public int age = 18;
    //不带参数的构造方法
    public Student(){
        System.out.println("Student()");
    }

    private Student(String name,int age) {
        this.name = name;
        this.age = age;
        System.out.println("Student(String,name)");
    }

    private void eat(){
        System.out.println("i am eat");
    }

    public void sleep(){
        System.out.println("i am pig");
    }

    private void function(String str) {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Class<?> c1 = s1.getClass();

        Class<?> c2 = Student.class;

        Class<?> c3  = null;
        try {
            c3 = Class.forName("Student");
        } catch (ClassNotFoundException exception) {
            exception.printStackTrace();
        }

        System.out.println(c1==c2);
        System.out.println(c3==c2);
        System.out.println(c1==c3);
    }
    //Class对象 只有一个
    public static void main1(String[] args) {
        Class<?> c1 = null;
        try {
            //                     demo1.Student
            c1 = Class.forName("Student");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Class c2 = Student.class;
        Student student = new Student();
        Class c3 = student.getClass();
        System.out.println(c1.equals(c2));
        System.out.println(c1.equals(c3));
        System.out.println(c2.equals(c3));
    }
}
