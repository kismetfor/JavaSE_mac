public class Main009 {

    public static int minSubArrayLen1(int target, int[] nums) {

        if (1 == nums.length) {
            if (nums[0] < target ) {
                return 0;
            } else {
                return 1;
            }
        }
        int left = 0;
        int right = left+1;
        if (nums[left] >= target) {
            return 1;
        }
        int sum = nums[left] + nums[right];
        int minLength = Integer.MAX_VALUE;
        while (right+1 < nums.length) {

            if (sum < target) {
                sum += nums[++right];
            } else {
                minLength = Math.min(minLength, right-left+1);
                sum -= nums[left++];
            }
        }
        //刚好整个数组长度之和为target

        while (left+1 < nums.length) {
            if (sum >= target) {
                minLength = Math.min(minLength, right-left+1);
            }
            sum -= nums[left++];
        }
        if (minLength==Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }
    public static int minSubArrayLen(int target, int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        int left = 0;
        int right = left;
        int sum = 0;sum += nums[right];
        int minLength = Integer.MAX_VALUE;
        while (right+1 < nums.length) {

            if (sum < target) {
                sum += nums[++right];
            } else {
                minLength = Math.min(right-left+1, minLength);
                //优化 当这个数就是>=target时直接返回
                if (minLength==1) {
                    return 1;
                }
                sum -= nums[left];
                left++;
            }
        }
        while (left+1< nums.length) {
            if (sum >= target) {
                minLength = Math.min(right-left+1, minLength);
            }
            sum -= nums[left];
            left++;
        }
        //最后一个数满足情况 补上测试条件
        if (sum >= target) {
            minLength = Math.min(right-left+1, minLength);
        }
        //没有更新时, 说明没有满足的数字
        if (minLength== Integer.MAX_VALUE) {
            return 0;
        }
        return minLength;
    }

    //209. 长度最小的子数组
    public static void main(String[] args) {

        int[] nums10 = {7};
        System.out.println(minSubArrayLen(7, nums10));
        System.out.println("======");

        int[] nums9 = {7,1,1,1,7};
        System.out.println(minSubArrayLen(7, nums9));
        System.out.println("======");

        int[] nums3 = {1,2,3,4,5};
        System.out.println(minSubArrayLen(15, nums3));
        System.out.println("======");

        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, nums));
        System.out.println("======");

        int[] nums5 = {10,2,3};
        System.out.println(minSubArrayLen(6, nums5));
        System.out.println("======");
        int[] nums4 = {5};
        System.out.println(minSubArrayLen(7, nums4));
        System.out.println("======");


        int[] nums1 = {1,4,4};
        System.out.println(minSubArrayLen(4, nums1));
        System.out.println("======");
        int[] nums2 = {1,1,1,1,1,1,1,1};
        System.out.println(minSubArrayLen(11, nums2));
        System.out.println("======");
    }
}
