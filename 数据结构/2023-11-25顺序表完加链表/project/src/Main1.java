import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {
        int numRows = 3;
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(1);
        ret.add(list);

        for (int i = 0; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);

            for (int j = 1; j < numRows-1; j++) {
                List<Integer> preRow = ret.get(i-1);
                int x = preRow.get(j-1)+ preRow.get(j);
                curRow.add(x);
            }

            curRow.add(1);
            ret.add(curRow);
        }
        return ret;
    }

}
