import java.util.Arrays;

public class Main012_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {1,1,4,2,3}; int x = 5;
//        int[] nums = {3,2,20,1,1,3}; int x = 10;
        int[] nums = {5,6,7,8,9}; int x = 4;
        System.out.println(solution.minOperations(nums, x));
    }
}
class Solution {
    public int minOperations(int[] nums, int x) {
        int sum_nums = 0;
        for (int i = 0; i < nums.length; i++) {
            sum_nums += nums[i];
        }
        int target = sum_nums - x;
        if (target < 0) return -1;
        if (target == 0) return nums.length;
        
        //滑动窗口
        int left = 0, right = 0;
        //最长窗口长度max_length
        int sum = nums[0], max_length = 0;

        while (right <= nums.length-1) {
            
            if (sum < target) {
                //进窗口
                if (right == nums.length-1) break;
                sum += nums[++right];
            } else if (sum == target) {
                max_length = Math.max(max_length, right - left + 1);
                //出窗口
                sum -= nums[left++];
            } else {
                //出窗口
                sum -= nums[left++];
            }
            
            
        }
        if (max_length == 0) return -1;
        return nums.length-max_length;
    }
}
