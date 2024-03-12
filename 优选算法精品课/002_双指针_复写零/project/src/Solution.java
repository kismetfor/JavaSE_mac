import java.util.Arrays;

class Solution {
    public static void duplicateZeros(int[] arr) {
        int cur = 0;
        int dest = -1;
        while(dest < arr.length-1) {
            if (arr[cur] == 0) {
                dest += 2;
            } else {
                dest++;
            }
            if (dest < arr.length-1) {
                cur++;
            }
        }
        //特殊情况单独考虑
        if (dest == arr.length) {
            arr[--dest] = 0;
            cur--;
            dest--;
        }
        while (cur >= 0) {
            if (arr[cur] == 0) {
                arr[dest--] = 0;
            }
            arr[dest] = arr[cur];
            cur--;dest--;
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1,0,2,3,0,4,5,0};
//        int[] arr = {1,0,2,3,0,4};
//        int[] arr = {0,1,7,6,0,2,0,7};
        int[] arr = {1,2,3};
        duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}