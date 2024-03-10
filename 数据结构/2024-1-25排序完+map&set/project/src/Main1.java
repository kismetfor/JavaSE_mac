import java.util.*;

public class Main1 {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s:
             words) {
            if (map.get(s)==null) {
                map.put(s, 1);
            } else {
                int val = map.get(s);
                map.put(s, val+1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            //根据value比较
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue().compareTo(o2.getValue()) == 0) {
                    //频率相同 大根堆存储
                    return o2.getKey().compareTo(o1.getKey());
                }
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        for (Map.Entry<String, Integer> entry:
             map.entrySet()) {
            if (minHeap.size() < k) {
                minHeap.offer(entry);
            } else {
                Map.Entry<String, Integer> top = minHeap.peek();
                if (top.getValue().compareTo(entry.getValue()) < 0) {
                    minHeap.poll();
                    minHeap.offer(entry);
                } else  if (top.getValue().compareTo(entry.getValue()) ==0 ){
                  //如果不同的单词有相同出现频率，按字典顺序排序。
                    if (top.getKey().compareTo(entry.getKey()) > 0) {
                        minHeap.poll();
                        minHeap.offer(entry);
                    } else {

                    }
                }
            }
        }

        List<String> ret = new ArrayList<>();
        while (k-- != 0) {
            Map.Entry<String, Integer> entry = minHeap.poll();
            ret.add(entry.getKey());
        }
        Collections.reverse(ret);
        return ret;
    }
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        //<K, V> K可比较 所有的比较都是
        map.put("abc", 1);
        map.put("abs", 3);
        map.put("int", 5);
        map.put("main", 6);
        map.put("nivo", 20);

        System.out.println(map.get("abs"));

        //把map的所有key取出来 放进set里面
        Set<String> set =  map.keySet();
        System.out.println(set);

        //把map的所有key和value取出来 放进set里面
        Set<Map.Entry<String,Integer>> set1 = map.entrySet();
        for (Map.Entry<String,Integer> entry: set1) {
            System.out.println("key: "+ entry.getKey()+" value: "+ entry.getValue());
        }
    }
}
