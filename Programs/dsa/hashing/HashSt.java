import java.util.HashSet;
import java.util.Iterator;

class HashSt{

    public static void main(String[] args){

        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        System.out.println(set);

        set.remove(10);
        System.out.println(set);

        System.out.println(set.size());

        Iterator it = set.iterator();
        while(it.hasNext()){

            System.out.println(it.next());
        }

    }
}