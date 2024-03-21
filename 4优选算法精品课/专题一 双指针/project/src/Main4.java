import java.util.Arrays;

public class Main4 {
    public static int triangleNumber(int[] arr) {
        //排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int ret = 0;
        int n = arr.length;
        int a = 0;
        int b = n-2;
        int c = n-1;
        while (c>=2 && b>=1) {
            if (arr[b]+arr[b-1]<=arr[c]) {
                c--;b--;
            }
            while (a<b) {
                while (true) {
                    if (arr[a]+arr[b] <= arr[c]) {
                        a++;
                    } else {
                        break;
                    }
                }
                ret += b-a;
            }
            c--;b--;
        }
        return ret;
    }
    public static void main(String[] args) {
//        int[] nums = {2,2,3,4};
        int[] nums = {4,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
