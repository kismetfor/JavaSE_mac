import java.util.HashSet;

public class Main010 {
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        //使用Set存储 去重复
        // 如果不存在的话 把right放进Set中
        
        // 如果存在的话 更新最大长度为right-left
        //用left找到重复元素的位置 范围是left到right 左闭右开 更新left
        // Set出left的 left++
        //right++ 再判断是否放入

    }

    public static void main(String[] args) {

    }
}
