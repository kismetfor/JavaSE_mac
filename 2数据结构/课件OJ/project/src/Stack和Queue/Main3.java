package Stack和Queue;

import java.util.Stack;

/**
 * 栈的压入、弹出序列
 */
public class Main3 {
    public static void main(String[] args) {
        int[] pushV = {1,2,3,4,5};
//        int[] popV = {4,3,5,1,2};
        int[] popV = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushV, popV));
    }
    public static boolean IsPopOrder (int[] pushV, int[] popV) {
        //入栈 : 为空
        int i = 0;
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (true) {
            if (i < pushV.length) {
                if (stack.isEmpty() || stack.peek() != popV[j]) {
                    stack.push(pushV[i++]);
                }
            }

            while (stack.peek() == popV[j]) {
                stack.pop();
                j++;
                if (stack.isEmpty()) break;
            }
            //最后一次判断一定是 先进入满了 下面这个条件符合了 进入的while循环 要么全部出了 要么没出完 但是push已经结束了
            if (i == pushV.length){
                return stack.isEmpty();
            }
        }
        //出栈 : 与popV数组的值相符合
    }

}
