import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main7 {
    public static List<List<Integer>> threeSum(int[] arr) {
        List<List<Integer>> ret = new ArrayList<>();
        if (arr.length < 3) {
            return ret;
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            if (arr[i] > 0) {
                break;
            }
            while (i!=0 && i < arr.length-2 && arr[i] == arr[i-1]) {
                i++;
            }
            int t = Math.abs(arr[i]);
            int left = i+1;
            int right = arr.length-1;
            while (left<right) {
                int sum = arr[left]+arr[right];
                if (sum > t) {
                    right--;
                } else if (sum < t) {
                    left++;
                } else {
                    ret.add(new ArrayList<Integer>(Arrays.asList(arr[i], arr[left], arr[right])));
                    //去重
                    do {
                        left++;
                    }while ( left < arr.length-1 && arr[left]==arr[left-1]);
                    do {
                        right--;
                    }while (arr[right]==arr[right+1] && left < right) ;
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
       int[] nums = {-1, 0, 1, 2, -1, -4};
//       int[] nums = {0,0,0, 0};
//       int[] nums = {-2,0,1, 1,2};
        List<List<Integer>> list = threeSum(nums);
        System.out.println(list);
    }
}
