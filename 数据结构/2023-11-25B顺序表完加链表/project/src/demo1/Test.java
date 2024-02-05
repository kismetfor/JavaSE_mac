package demo1;

public class Test {
    public static void main(String[] args) {
        MySingleList mySingleList = new MySingleList();
        mySingleList.creatList();
        System.out.println();
        mySingleList.display();
        System.out.println();
        System.out.println("====");
        System.out.println(mySingleList.contains(45));
        System.out.println(mySingleList.size());
        System.out.println("====");
        mySingleList.addFirst(56);
        mySingleList.display();
        System.out.println();
        System.out.println("====");
        mySingleList.addLast(67);
        mySingleList.display();
        System.out.println();
        System.out.println("====addIndex");
        mySingleList.addIndex(3, 33);
        mySingleList.display();

        System.out.println();
        System.out.println("====remove");
        mySingleList.remove( 67);
        mySingleList.display();
    }
}
