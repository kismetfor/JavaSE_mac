import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main8 {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int l = nums.length;
        if (l < 4) {
            return lists;
        }
        //找到数a的位置 让后面三个数等于target-a
        for (int a = 0; a < l-3; a++) {
            //去重
            while (a!=0 && a < l-3 && nums[a]==nums[a-1]) {
                a++;
            }
            if (a==l-3) {
                return lists;
            }
            for (int b = a+1; b < l-2; b++) {
                //去重
                while (b!=a+1 && b < l-2 && nums[b]==nums[b-1]) {
                    b++;
                }

                //找到数b的位置 让后面两个数等于target-a-b
                long t = (long)target-nums[a]-nums[b];

                //使用双指针找到两数之和
                int left = b+1;
                int right = l-1;
                while (left < right) {
                    long sum = nums[left] + nums[right];

                    if (sum < t) {
                        left++;
                    } else if (sum > t) {
                        right--;
                    } else {
                        lists.add(new ArrayList<>(Arrays.asList(nums[a],nums[b],nums[left], nums[right])));
                        //去重
                        do {
                            left++;
                        } while (left<right && nums[left]==nums[left-1]);
                        do {
                            right--;
                        } while (left<right && nums[right]==nums[right+1]);
                    }
                }
            }
        }
        return lists;



    }

    public static void main(String[] args) {
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int t = -294967296;
        System.out.println(fourSum(nums, t));
    }
    public static void main1(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
//        int[] nums = {-2, -1, -1, 1, 1, 2, 2};
//        int[] nums = {2,2,2,2,2};
        System.out.println(fourSum(nums, 8));
//        System.out.println(fourSum(nums, 0));
//        System.out.println(fourSum(nums, 0));
    }
}
