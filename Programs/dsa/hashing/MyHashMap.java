class MyHashMap {

    static class Node {

        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Node[] table;

    MyHashMap(int size) {
        table = new Node[size];
    }

    int hash(int key) {
        return Math.abs(key) % table.length;
    }

    void put(int key, int value) {

        int index = hash(key);

        if (table[index] != null && table[index].key == key) {

            table[index].value = value;
            return;
        }

        table[index] = new Node(key, value);
    }

    int get(int key) {

        int index = hash(key);

        if (table[index] != null && table[index].key == key) {
            return table[index].value;
        }

        return -1;
    }

    boolean containsKey(int key) {

        int index = hash(key);

        return table[index] != null && table[index].key == key;
    }

    public static void main(String[] args) {

        MyHashMap map = new MyHashMap(10);

        map.put(1, 100);
        map.put(2, 200);
        map.put(3, 300);

        System.out.println(map.get(2));

        System.out.println(map.containsKey(3));

        System.out.println(map.containsKey(5));
    }
}