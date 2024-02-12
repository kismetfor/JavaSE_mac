package demo;

public interface IList {
    void addFirst(int data);
    void addLast(int data);
    void addIndex(int index,int data);
    boolean contains(int key);
    void remove(int key);
    void removeAllKey(int key);
    int size();
    void clear();
    void display();
}
