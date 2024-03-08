package demo2;

public class HashBuck2 <K, V>{
    static class Node <K,V>{
        K key;
        V val;
        Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }

    }
    Node<K,V>[] array = new Node[10];
    int usedSize;
    static final double LOAD_FACTOR = 0.75;
    void push(K key, V val) {
        Node<K,V> node = new Node<>(key, val);
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur!=null) {
            if (cur.key.equals(key)) {
                cur.val = val;
            }
            cur = cur.next;
        }
        node.next = array[index];
        array[index] = node;
        usedSize++;
    }
    V get(K key) {
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];
        while (cur!=null) {
            if (cur.key.equals(key)) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }
}
