import java.util.*;

class Main{

    public static Map<Integer, Integer> topFreqEle(List<Integer> list){

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int value : list){

            if(map.containsKey(value)){

                map.put(value, map.get(value) + 1);
            }
            else{

                map.put(value, 1);
            }
        }

        return map;

    }

    public static void main(String[] args){

        List<Integer> list = List.of(1, 1, 2, 2, 3, 4, 3, 3);
        System.out.println(topFreqEle(list));
    }
}