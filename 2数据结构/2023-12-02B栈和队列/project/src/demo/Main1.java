package demo;

import java.util.Stack;

public class Main1 {
    public static void main(String[] args) {
        String s = "[()]}";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch=='('||ch=='['||ch=='{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if(ch!=symbol(stack.pop())) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static char symbol(char ch) {
        return switch (ch) {
            case '(' -> ')';
            case '[' -> ']';
            case '{' -> '}';
            default -> '0';
        };
    }
}
