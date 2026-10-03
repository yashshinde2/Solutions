import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TopFreq{

    public static Map<Integer, Integer> freqEle(List<Integer> list) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int value : list) {
           
            if (map.containsKey(value)) {
                map.put(value, map.get(value) + 1);
            } else {
                map.put(value, 1);
            }

        }

        return map;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 1, 2, 3, 4, 4, 5);
        System.out.println(freqEle(list));
    }
}