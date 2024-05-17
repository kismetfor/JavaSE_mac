import java.util.ArrayList;
import java.util.List;

public class Main014 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
    public static void main1(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> list = findAnagrams(s, p);
        System.out.println(list);
    }
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> list  = new ArrayList<>();
        char[] ps = p.toCharArray();
        int[] hashp = new int[26];

        for (int left = 0, right = p.length(); left < s.length(); left++) {

        }
    }
    public static List<Integer> findAnagrams1(String s, String p) {
        List<Integer> list  = new ArrayList<>();
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int[] hashp = new int[26];
        for (char x:
             ps) {
            hashp[x-'a']++;
        }

        boolean flag = true;

        for (int i = 0; i <= s.length()-p.length(); i++) {
            String sub = s.substring(i, i+p.length());
            char[] subs = sub.toCharArray();
            int[] hashs = new int[26];
            for (char x:
                    subs) {
                hashs[x-'a']++;
            }

            for (int j = 0; j < hashs.length; j++) {
                if (hashp[j] != hashs[j]) {
                    flag = false;break;
                }
            }
            if (flag) {
                list.add(i);
            } else {
                flag = true;
            }

        }
        return list;
    }
}
