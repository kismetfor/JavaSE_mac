package demo1;

public interface IList {
    void addFirst(int data);
    void addLast(int data);
    void addIndex(int index, int data);
    boolean contains(int ksy);
    void remove(int key);
    void removeAllKsy(int key);
    int size();
    void clear();
    void display();
}
