import java.util.*;

class HashMp{

    public static void main(String[] args){

        HashMap<String, Integer> map = new HashMap<>();

        map.put("India", 1);
        map.put("USA", 2);
        map.put("UK", 3);

        System.out.println(map);

        map.remove("USA");
        System.out.println(map);

        if(map.containsKey("India")){

            System.out.println("Found");
        }

        System.out.println(map.get("UK"));

        for(Map.Entry<String, Integer> e : map.entrySet()){

            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }

        
    }
}