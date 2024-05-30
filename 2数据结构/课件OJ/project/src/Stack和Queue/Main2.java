package Stack和Queue;

import java.util.Stack;

/**
 * 逆波兰表达式求值
 */
public class Main2 {
    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};
//        String[] tokens ={"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
    public static int evalRPN(String[] tokens) {
        int ret = 0;
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (stack.size() < 2) {
                stack.push(tokens[i]);
            } else {
                //容量足以进行运算的时候
                //分两种情况
                //1. 运算符
                //2. 数字
                if (tokens[i].equals("+") ||
                        tokens[i].equals("-") ||
                        tokens[i].equals("*") ||
                        tokens[i].equals("/")) {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    int c = 0;
                    switch (tokens[i]) {
                        case "+": c = a + b; break;
                        case "-": c = b - a; break;
                        case "*": c = a * b; break;
                        case "/": c = b / a; break;
                        default:
                            System.out.println("错误");
                    }
                    stack.push(Integer.toString(c));
                } else {
                    stack.push(tokens[i]);
                }
            }
        }
        ret = Integer.parseInt(stack.pop());
        return ret;
    }
}
