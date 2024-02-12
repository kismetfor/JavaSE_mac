package demo;

public class myLinkedList implements IList{
    ListNode head;
    ListNode last;
    static class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        public ListNode(int val) {
            this.val = val;
        }
    }
    @Override
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        if (head==null) {
            head = node;
            last = node;
        } else {
            head.prev = node;
            node.next = head;
            head = node;
        }

    }

    @Override
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if(head==null) {
            head = node;
            last = node;
        } else {
            node.prev = last;
            last.next = node;
            last = node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        if (index<0||index>size()) {
            throw new IndexException("双向链表插入, Index不合法: "+index);
        }
        if(index==0) {
            addFirst(data);
            return;
        }
        if (index==size()) {
            addLast(data);
            return;
        }
        ListNode cur = findIndex(index);
        ListNode node = new ListNode(data);
        cur.prev.next = node;
        node.prev = cur.prev;
        node.next = cur;
        cur.prev = node;
    }

    private ListNode findIndex(int index) {
        ListNode cur = head;
        while (index--!=0) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur = head;
        while (cur!=null) {
            if (cur.val==key) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if (head.val==key) {
            head = head.next;
            if (head!=null) {
                head.prev = null;
            } else {
                //只有一个节点 且是需要删除的节点
                last = null;
            }
            return;
        }
        ListNode del = head.next;
        while (del.next!=null) {
            if(del.val==key) {
                del.next.prev = del.prev;
                del.prev.next = del.next;
                return;
            }
            del = del.next;
        }
        if(last.val==key) {
            last = last.prev;
            last.next = null;
        }
    }

    @Override
    public void removeAllKey(int key) {
        ListNode del = head;
        while (del!=null) {
            if (del.val==key) {
                if (del==head) {
                    head = head.next;
                    if (head!=null) {
                        head.prev = null;
                    } else {
                        last = null;
                    }
                } else if (del==last) {
                    last = last.prev;
                    if (last!=null) {
                        last.next = null;
                    } else {
                        head = null;
                    }
                } else {
                    del.prev.next = del.next;
                    del.next.prev = del.prev;
                }
            }
            del = del.next;
        }
    }

    @Override
    public int size() {
        int count = 0;
        ListNode cur = head;
        while (cur!=null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    public void clear() {

    }

    @Override
    public void display() {
        ListNode cur = head;
        while (cur!=null) {
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();
    }
}
