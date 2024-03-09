import java.util.HashMap;
import java.util.Map;

public class Main2 {
    static HashMap<Integer, Integer> countNums(int[] array) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x:
             array) {
            if (map.get(x)==null) {
                map.put(x, 1);
            } else {
                int val = map.get(x);
                map.put(x, val+1);
            }
        }
        return map;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,1,3,3,3,2,2,5,5,5,5,5,7,8,9,0};
        HashMap<Integer, Integer> map = countNums(arr);
        for (Map.Entry<Integer, Integer> entry:
                map.entrySet()) {
            System.out.println(entry.getKey()+" 出现次数 "+entry.getValue());
        }
    }
}
