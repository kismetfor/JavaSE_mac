package demo;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            if(!isSymbol(tokens[i])) {
                stack.push(Integer.valueOf(tokens[i]));
            } else {
                Integer num2 = stack.pop();
                Integer num1 = stack.pop();
                switch (tokens[i]) {
                    case "+" :
                        stack.push(num1+num2);
                        break;
                    case "-" :
                        stack.push(num1-num2);
                        break;
                    case "*" :
                        stack.push(num1*num2);
                        break;
                    case "/" :
                        stack.push(num1/num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
    public static boolean isSymbol(String str) {
        if(str.equals("+")||str.equals("-")||str.equals("*")||str.equals("/")) {
            return true;
        }
        return false;
    }
}
