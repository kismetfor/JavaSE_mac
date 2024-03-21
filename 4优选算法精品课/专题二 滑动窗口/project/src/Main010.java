import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main010 {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
//        System.out.println(lengthOfLongestSubstring(s1));
        String s2 = "tmmzuxt";
        System.out.println(lengthOfLongestSubstring(s2));
    }
    public static int lengthOfLongestSubstring(String ss) {
        char[] s = ss.toCharArray();
        int[] hash = new int[128]; //数组模拟哈希表
        int left = 0;
        int right = 0;
        int n = ss.length();
        int ret = 0;
        while (right < n) {
            hash[s[right]]++; //进入哈希表
            while (hash[s[right]] > 1) { //出现重复字符
                hash[s[left++]]--; //出窗口
            }
            ret = Math.max(ret, right-left+1);
            right++;
        }
        return ret;
    }
    public static int lengthOfLongestSubstring3(String s) {
        int ret = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
    public int lengthOfLongestSubstring2(String s) {
        int ret = 0;
        int left = 0, right = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            char ch = s.charAt(right);
            if (!set.contains(ch)) {
                set.add(ch);
            } else {


                //left走到冲突字符处
                //加加

                 set.remove(ch);
                ret = Math.max(ret, right-left+1);
                left++;
            }

            right++;
        }
        return ret;
    }
    public static int lengthOfLongestSubstring1(String s) {
        if (s.length()==1) return 1;
        HashSet<Character> set = new HashSet<>();
        //使用Set存储 去重复
        int left = 0;
        int right = 0;
        int maxLength = 0;
        while (right+1 < s.length()) {
            char ch = s.charAt(right);

            if (!set.contains(ch)) {
                maxLength = Math.max(maxLength, right-left+1);
                // 如果不存在的话 把right放进Set中
                set.add(ch);
                right++;
            } else {
                // 如果存在的话 更新最大长度为right-left
                maxLength = Math.max(maxLength, right-left);
                //用left找到重复元素的位置 范围是left到right 左闭右开 更新left
                while (left < right) {
                    set.remove(s.charAt(left));
                    if (s.charAt(left)==ch) {
                        break;
                    } else {
                        left++;
                    }
                }
                // Set出left的 left++
                //right++ 再判断是否放入
                left++;right++;
                set.add(s.charAt(left));
            }
//            补上判断 因为right刚到边界的时候就退出了
        }
        char ch = s.charAt(right);
        if (!set.contains(ch)) {
            maxLength = Math.max(maxLength, right-left+1);
        } else {
            while (left < right) {
                set.remove(s.charAt(left));
                if (s.charAt(left)==ch) {
                    break;
                } else {
                    left++;
                }
            }
            maxLength = Math.max(maxLength, right-left);
        }

        return maxLength;

    }

    public static void main1(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "eeee";
        String s3 = "pwwkew";
//        String s3 = "pwwkea";
//        String s3 = "pwwkek";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
    }
}
