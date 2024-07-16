public class Main0001 {
    //https://leetcode.cn/problems/longest-palindromic-substring/description/
    public static void main(String[] args) {

    }
    public String longestPalindrome(String s) {
        int maxLength = 1;
        String longestString = "";
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            left = i; right = s.length()-1;
            while (right-left+1 < maxLength) {

            }
        }
    }
    public static boolean ishuiwen(String str) {
        char[] chars = str.toCharArray();
        int i = 0;
        int j = chars.length-1;
        while(i < j) {
            if (chars[i] != chars[j]) return false;
            i++;j--;
        }
        return true;
    }
}
