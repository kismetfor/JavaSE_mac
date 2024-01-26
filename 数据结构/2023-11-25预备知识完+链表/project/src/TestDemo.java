public class TestDemo {
    public static void main(String[] args) {
        MyArrayList myArrayList = new MyArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        myArrayList.add(6);

        System.out.println(myArrayList.contains(5));
        System.out.println(myArrayList.indexOf(2));

        myArrayList.remove(3);
        myArrayList.display();
    }
}