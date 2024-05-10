import java.util.Arrays;

public class Main012_1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,4,2,3}; int x = 5;
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
        int sum = 0, max_length = 0;

        while (right <= nums.length-1) {
            
            if (sum < target) {
                //进窗口
                sum += nums[right++];
            } else if (sum == target) {
                max_length = right - left + 1;
            } else {
                //出窗口
                sum -= nums[left++];
            }
            
            
        }
        return nums.length-max_length;
    }
}
