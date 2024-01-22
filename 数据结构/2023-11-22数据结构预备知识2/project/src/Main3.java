class Myarray<T> {
    public T[] array = (T[]) new Object[10];

    public void setValue(int pos, T val) {
        array[pos] = val;
    }
    public T getValue(int pos) {
        return array[pos];
    }
}
class Person {
    String name;
    int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Main3 {
    public static void main(String[] args) {
        Myarray<String> myarray = new Myarray<>();
        myarray.setValue(0, "hello");
        String str = myarray.getValue(0);
9
        Myarray<Person> myarray1 = new Myarray<>();
        myarray1.setValue(0, new Person("张三", 22));
        Person person = myarray1.getValue(0);
        System.out.println(person);
    }
}
