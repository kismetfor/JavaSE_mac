public class Main011 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        System.out.println(longestOnes(nums, 2));

        int[] n1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println(longestOnes(n1, 3));
    }
    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zero = 0;
        int ret = 0;
        while (right < nums.length) {
                if (nums[right] == 0) {
                    zero++;
                }
            //让left移动到 满足0个数等于k的位置去 这样right又可以往后走
            // 计算左指针需要移动的步数
            while (zero > k) {
                if (nums[left++]==0) {
                    zero--;
                }
            }
            ret = Math.max(ret, right - left + 1);
            right++;
        }
        return ret;
    }
    public static int longestOnes1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zero = 0;
        int ret = 0;
        while (left < nums.length) {
            while (right < nums.length && zero <= k) {
                if (nums[right] == 0) {
                    zero++;
                }
                if (zero <= k) {
                    ret = Math.max(ret, right - left + 1);
                }
                right++;
            }
            left++;
            right = left;
            zero = 0;
        }
        return ret;
    }
}
