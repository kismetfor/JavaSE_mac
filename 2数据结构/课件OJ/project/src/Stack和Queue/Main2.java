package Stack和Queue;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class Main2 {
    public int evalRPN(String[] tokens) {
        int ret = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (stack.size() < 2) {
                stack.push(tokens[i]);
            } else {
                if (tokens[i].equals("+")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());

                } else if (tokens[i].equals("-")) {

                } else if (tokens[i].equals("*")) {

                } else if (tokens[i].equals("/")) {

                } else {
                    stack.push(tokens[i]);
                }
            }
        }
        //先入栈

        //遇到运算符出栈

        //再入栈

    }
}
