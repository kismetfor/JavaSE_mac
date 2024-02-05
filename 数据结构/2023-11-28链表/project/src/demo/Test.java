package demo;

public class Test {
    public static void main(String[] args) {
        mySingleList mySingleList = new mySingleList();
        mySingleList.creatList();
        mySingleList.display();

        System.out.println();
        System.out.println("=====remove");
        mySingleList.remove(56);
        mySingleList.display();

        System.out.println();
        System.out.println("=====addFirst");
        mySingleList.addFirst(21);
        mySingleList.display();

        System.out.println();
        System.out.println("=====addLast");
        mySingleList.addLast(67);
        mySingleList.display();

        System.out.println();
        System.out.println("=====addIndex");
        mySingleList.addIndex(3, 33);
        mySingleList.display();

/*        System.out.println();
        System.out.println("=====addIndex: 不合法Index示例");
        mySingleList.addIndex(99, 33);*/

        System.out.println();
        System.out.println("=====remove");
        mySingleList.remove(33);
        mySingleList.display();
        System.out.println();

        System.out.println("=====removeAllKey");
        mySingleList.addIndex(3, 33);
        mySingleList.addIndex(3, 33);
        mySingleList.addFirst(21);
        mySingleList.addFirst(21);
        mySingleList.display();
        System.out.println();
        mySingleList.removeAllKey(21);
        mySingleList.display();

        System.out.println();
        System.out.println("=====size");
        System.out.print(mySingleList.size());



    }
}
