import java.util.HashMap;
import java.util.HashSet;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
    public Node copyRandomList1(Node head) {
        HashMap<Node, Node> map = new HashMap<>();
        Node cur = head;
        while (cur!=null) {
            Node node = new Node(cur.val);
            map.put(cur, node);
            cur = cur.next;
        }
        cur = head;
        while (cur!=null) {
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(cur);
    }


        public Node copyRandomList(Node head) {
        Node cur = head;
        Node node = null;
        Node ret = node;
        Node nodeNext = null;
        Node nodeRandom = null;
        while (cur!=null) {
            node = new Node(cur.val);
            if (node.next!=null) {
                nodeNext = new Node(cur.next.val);
            }
            if (node.random!=null) {
                nodeRandom = new Node(cur.random.val);
            }
            node.next = nodeNext;
            node.random = nodeRandom;
            cur = cur.next;
            node = node.next;
        }
        return ret;
    }
    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                count++;
            }
        }
        return count;
    }
    public int singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return nums[i];
            }
        }
        return -1;
    }
}
