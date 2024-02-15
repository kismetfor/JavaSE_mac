package demo;

import java.util.Stack;

public class Main2 {
    public static void main(String[] args) {
        int a[] = {1,2,3,4,5};
        int b[] = {4,5,3,2,1};
//        int b[] = {4,3,5,1,2};
        System.out.println(IsPopOrder(a, b));
    }
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushV.length; i++) {
            stack.push(pushV[i]);
            while (!stack.isEmpty() &&stack.peek()==popV[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
