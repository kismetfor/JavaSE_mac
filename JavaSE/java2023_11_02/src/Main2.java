public class Main2 {
    //java中 定义二维数组 可以省略列
    public static void main(String[] args) {
        int[][] arr = new int[2][];
        System.out.println(arr.length);
//        System.out.println(arr[0].length);
        arr[0] = new int[3];
        arr[1] = new int[4];
        System.out.println(arr[1].length);
        //可以new出不规则数组--每一行的列数不完全相同
    }
}
