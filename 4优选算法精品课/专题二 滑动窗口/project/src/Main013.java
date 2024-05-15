import java.util.HashMap;
import java.util.HashSet;

public class Main013 {
    public static void main(String[] args) {
//        int[] fruits = {0,1,2,2};
//        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
//        int[] fruits = {1,2,1};

        int[] fruits = {1,2,3,2,2};
        Solution1 solution = new Solution1();
        System.out.println(solution.totalFruit2(fruits));
    }
}
class Solution1 {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int[] lanzi = new int[n+1];
        int right, left, kinds;
        int max = 0;
        for ( right = 0, left = 0, kinds = 0; right < n; right++) {
            int in = fruits[right];
            if (lanzi[in]==0) kinds++;
            lanzi[in]++;

            while (kinds > 2 && right < n-1) {
                int out = fruits[left];
                lanzi[out]--;
                if (lanzi[out]==0) kinds--;
                left++;
            }
            max = Math.max(max, right-left+1);
        }
        return max;
    }

    public int totalFruit2(int[] fruits) {
        int n = fruits.length;
        int[] lanzi = new int[n+1];
        int right, left, kinds;
        int max = 0;
        for ( right = 0, left = 0, kinds = 0; right < n; right++) {
            int in = fruits[right];
            if (lanzi[in]==0) kinds++;
            lanzi[in]++;

            while (kinds > 2) {
                int out = fruits[left];
                lanzi[out]--;
                if (lanzi[out]==0) kinds--;
                left++;

                int in1 = fruits[right];
                if (lanzi[in1]==0) kinds++;
                lanzi[in1]++;
            }

        }
        return right-left;
    }

    /*
    1 <= fruits.length <= 105
    0 <= fruits[i] < fruits.length
     */
    public int totalFruit1(int[] fruits) {
        int n = fruits.length;
        int[] lanzi = new int[n];

        int right = 0, left = 0, kinds = 0;
        for (; right < n; right++) {
            //进窗口
            int in = fruits[right];
            if (lanzi[in] == 0) kinds++;
            lanzi[in]++;

            while (kinds > 2) {
                int out = fruits[left];
                fruits[out]--;
                if (fruits[out] == 0) kinds--;
                left++;
            }
        }
        return right-left;
    }
}
