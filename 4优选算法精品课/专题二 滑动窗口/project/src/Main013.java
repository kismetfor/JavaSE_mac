import java.util.HashMap;
import java.util.HashSet;

public class Main013 {
    public static void main(String[] args) {
//        int[] fruits = {0,1,2,2};
//        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
//        int[] fruits = {1,2,1};
//        int[] fruits = {1,2,3,2,2};
        int[] fruits = {0,1,6,6,4,4,6};
//        int[] fruits = {0,1,2};
        Solution1 solution = new Solution1();
        System.out.println(solution.totalFruit2(fruits));
    }
}
class Solution1 {
    public int totalFruit(int[] fruits) {
        //老师的方法
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
    public int totalFruit3(int[] fruits) {
        //自己的方法
        int n = fruits.length;
        int[] lanzi = new int[n+1];
        int right, left, kinds;
        //偏移量
        int offset = -1;

        boolean flag = false;

        for ( right = 0, left = 0, kinds = 0; right < n; right++) {

            int in = fruits[right];
            if (lanzi[in]==0) kinds++;
            lanzi[in]++;
            if (flag) {
                offset++;
                flag=false;
            }

            while (kinds > 2 && right < n-1) {
                flag = true;

                int out = fruits[left];
                lanzi[out]--;
                if (lanzi[out]==0) kinds--;
                left++;

                right++;
                int in1 = fruits[right];
                if (lanzi[in1]==0) kinds++;
                lanzi[in1]++;

            }
            if (kinds > 2 && right == n-1) {
                return right-left;
            }


        }
        if (offset != -1) return right-left-offset;
        return right-left;
    }

    public int totalFruit2(int[] fruits) {
        //自己的方法
        int n = fruits.length;
        int[] lanzi = new int[n+1];
        int right, left, kinds;
        //偏移量
        int offset = -1;

        //记录内循环次数
        int count = 0;
        for ( right = 0, left = 0, kinds = 0; right < n; right++) {

            int in = fruits[right];
            if (lanzi[in]==0) kinds++;
            lanzi[in]++;

            while (kinds > 2 && right < n-1) {
                if (count == 0) offset++;
                count++;


                int out = fruits[left];
                lanzi[out]--;
                if (lanzi[out]==0) kinds--;
                left++;

                right++;
                int in1 = fruits[right];
                if (lanzi[in1]==0) kinds++;
                lanzi[in1]++;

//                if (right == n-1) {
//                    return right-left-offset;
//                }
                if (kinds == 2)
                    count = 0;
            }
            if (kinds > 2 && right == n-1) {
                return right-left;
            }


        }
        if (offset != -1) return right-left-offset;
        return right-left;
    }

}
