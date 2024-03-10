import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author 12629
 * @Description：
 */
public class ReflectClassDemo {
    public static void main(String[] args) {
        reflectNewInstance();
    }

    public static void reflectNewInstance() {
        Class<?> c1 = null;
        try {
            //                     demo1.Student
            c1 = Class.forName("Student");
            Student student = (Student)c1.newInstance();

            System.out.println(student);

        }catch (ClassNotFoundException
                | InstantiationException
                | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateConstructor() {
        Class<Student> c1 = null;
        try {
            //                     demo1.Student
            c1 = (Class<Student>)Class.forName("Student");
            Constructor<Student> constructor =  c1.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);

            Student student = constructor.newInstance("佩奇",10);

            System.out.println(student);

        }catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException
                e) {
            e.printStackTrace();
        }
    }

    public static void reflectPrivateField() {
        Class<Student> c1 = null;
        try {
            //                     demo1.Student
            c1 = (Class<Student>)Class.forName("Student");
            Field field = c1.getDeclaredField("name");
            field.setAccessible(true);

            Student student = (Student)c1.newInstance();

            field.set(student,"沸羊羊");

            System.out.println(student);


        }catch (ClassNotFoundException | NoSuchFieldException
                e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reflectPrivateMethod() {
        Class<Student> c1 = null;
        try {
            //                     demo1.Student
            c1 = (Class<Student>)Class.forName("Student");
            Method method = c1.getDeclaredMethod("function",String.class);

            method.setAccessible(true);

            Student student = c1.newInstance();

            method.invoke(student,"hello every one");

        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main1(String[] args) {
        //reflectNewInstance();
        //reflectPrivateConstructor();
        //reflectPrivateField();
        reflectPrivateMethod();
    }
}
