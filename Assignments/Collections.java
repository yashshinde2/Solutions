import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class Collections {
    public static void main(String[] args) {
    
        ArrayList<String> customers = new ArrayList<>();
        customers.add("Yash");
        customers.add("Aditya");
        customers.add("Suhas");

        System.out.println("Customers: " + customers);

        HashMap<String, Integer> products = new HashMap<>();
        products.put("Milk", 68);
        products.put("Bread", 30);
        products.put("Eggs", 7);

        System.out.println("Price of Bread: " + products.get("Bread"));
        System.out.println("Price of Milk: " + products.get("Milk"));
        System.out.println("Price of Eggs: " + products.get("Eggs"));

        TreeSet<Integer> sortedPrices = new TreeSet<>(products.values());
        System.out.println("Sorted product prices: " + sortedPrices);
    }
}
