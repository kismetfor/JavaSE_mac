package Stack和Queue;

import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        String s = "(){}}{";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (stack.isEmpty() || !pipei(stack.peek(), ch)) {
                //入栈
                stack.push(ch);
            } else {
                //出栈
                if (pipei(stack.peek(), ch)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public static boolean pipei(char ch1, char ch2) {
        if (ch1 == '(') {
            return ch2 == ')';
        }  else if (ch1 == '[') {
            return ch2 == ']';
        } else if (ch1 == '{') {
            return ch2 == '}';
        }
        return false;
    }
}
