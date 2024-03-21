import java.util.*;

public class Solution {
    //NC228 判断子序列
    public boolean isSubsequence (String S, String T) {
        //是否可以从 T 删除一些字符转换成 S。
        int j = 0; //控制S
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i)==S.charAt(j)) {
                j++;
            }
        }
        return j == S.length();
    }
  // AB5 点击消除
  public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      // 注意 hasNext 和 hasNextLine 的区别
      while (in.hasNext()) { // 注意 while 处理多个 case
          String str = in.nextLine();
          fun(str);
      }
  }
  public static void fun(String s) {
        Stack<Character> stack = new Stack<>();
      for (int i = 0; i < s.length(); i++) {
          char c = s.charAt(i);
          if (stack.isEmpty() || stack.peek()!=c) {
              stack.push(c);
          } else {
              stack.pop();
          }
      }
      if (stack.isEmpty()) {
          System.out.print("0");
          return;
      }
      Stack<Character> stack1 = new Stack<>();
     while (!stack.isEmpty()) {
         stack1.push(stack.pop());
     }
     while (!stack1.isEmpty()) {
         System.out.print(stack1.pop());
     }
  }
}
