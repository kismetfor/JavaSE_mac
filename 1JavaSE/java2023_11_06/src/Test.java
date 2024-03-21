public class Test {
    public int aMethod() {
//        static int i = 0;
        int i = 0;
        //static修饰的变量 只能是类变量 不能定义在方法内部
        i++;
        return i;
    }
    public static void main(String[] args) {
        Test test = new Test();
        test.aMethod();
        int j = test.aMethod();
        System.out.println(j);
    }
}
