package demo;

public class Test {
    public static void main(String[] args) {
        BinarySearchTree b = new BinarySearchTree();
        b.insert(15);
        b.insert(9);
        b.insert(23);
        b.insert(3);
        b.insert(12);
        b.insert(17);
        b.insert(28);
        b.insert(8);
        b.insert(22);
        b.remove(23);
        System.out.println();
    }
}
