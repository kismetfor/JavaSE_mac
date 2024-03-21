public class Main5 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(mytoString(arr));
        int[] arr1 = null;
        System.out.println(mytoString(arr1));
    }
    public static String mytoString(int[] arr){
        if(arr == null){
            return "NULL";
        }
        String ret =  "[";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
            if(i != arr.length-1) {
                ret += ',';
            }
        }
        ret += ']';
        return ret;
    }
}
