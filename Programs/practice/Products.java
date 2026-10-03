import java.util.*;

public class Products {

    static List<String> topKFrequent(List<String> list, int k) {

        HashMap<String, Integer> map = new HashMap<>();

        // Count frequency
        for (String str : list) {

            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        // Store unique elements
        List<String> unique = new ArrayList<>(map.keySet());

        // Sort by frequency - highest first
        unique.sort((a, b) -> map.get(b) - map.get(a));

        // Return top k
        return new ArrayList<>(
            unique.subList(0, Math.min(k, unique.size()))
        );
    }

    public static void main(String[] args) {

        List<String> list = Arrays.asList(
            "apple",
            "banana",
            "apple",
            "orange"
        );

        int k = 2;

        System.out.println(topKFrequent(list, k));
    }
}