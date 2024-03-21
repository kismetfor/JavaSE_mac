public class Main6 {
    public int[] twoSum(int[] arr, int t) {
        int left = 0;
        int right = arr.length-1;
        while (left<right) {
            int sum = arr[left]+arr[right];
            if (sum > t) {
                right--;
            } else if (sum < t) {
                left++;
            } else {
                return new int[] {arr[left], arr[right]};
            }
        }
        return new int[] {};
    }
}
