import java.util.ArrayList;
import java.util.List;

public class Main1 {
    //杨辉三角
    public static List<List<Integer>> generate(int numRows) {
        //初始化preRow
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> preRow = new ArrayList<>();
        preRow.add(1);
        ret.add(new ArrayList<>(preRow));
        if (numRows==1) return ret;
        //当numRows为1时直接返回
        preRow.add(1);
        ret.add(new ArrayList<>(preRow));
        if (numRows==2) return ret;
        //当numRows为2时直接返回
        for (int i = 2; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j==0 || j==i) {
                    curRow.add(1);
                } else if (j==1 || j==i-1) {
                    curRow.add(i);
                } else {
                    int a = preRow.get(j-1);
                    int b = preRow.get(j);
                    curRow.add(a+b);
                }
            }
            ret.add(curRow);
            preRow = curRow;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(generate(1));
        System.out.println(generate(2));
        System.out.println(generate(3));
        System.out.println(generate(4));
        System.out.println(generate(5));
    }
}
