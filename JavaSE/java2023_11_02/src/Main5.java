public class Main5 {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        int[][] arr1 = new int[2][];
        arr1[0] = new int[3];
        arr1[1] = new int[2];
        for (int[] intx:
             arr) {
            for (int x:
                 intx) {
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }

}
