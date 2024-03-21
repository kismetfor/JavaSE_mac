class MyArray<T extends Number> {
    public Object[] objects = new Object[10];
    public void setObjects(int pos, T val) {
        objects[pos] = val;
    }
    public T get(int pos) {
        return (T) objects[pos];
    }
}
/*
求一个数组中的最大值的泛型类
 */
class Alg<T extends Comparable<T>> {
    public T findMax(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max)>0) {
                //说明引用数据类型
                // 不能直接通过大于等于号进行比较
                max = arr[i];
            }
        }
        return max;
    }
}
class Person implements Comparable<Person> {
    int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
class Alg3 {
    //静态泛型方法
    public static <T extends Comparable<T>> T finMaxVal(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max)>0) {
                max = arr[i];
            }
        }
        return max;
    }
}
public class Main1 {
    public static void main(String[] args) {
        Integer[] arr = {1,2,3,4,5,1};
        System.out.println(Alg3.finMaxVal(arr));
    }
    public static void main2(String[] args) {
        Integer[] array = {1,2,3,45,2,1212};
        Alg<Integer> alg = new Alg<>();
        System.out.println(alg.findMax(array));

        Alg<Integer> alg1 = new Alg<>();
//        System.out.println(alg1.findMax(new Person(1)));
    }
    public static void main1(String[] args) {
        MyArray<Integer> myArray = new MyArray<>();
        myArray.setObjects(0, 12);
        System.out.println(myArray.get(0));
    }
}
