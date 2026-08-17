public class Tries{

    static class Node{

        Node[] children = new Node[26];
        boolean eow;

        public Node(){

            for(int i=0; i<26; i++){

                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word){

        Node curr = root;

        for(int i = 0; i<word.length(); i++){

            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null){

                curr.children[idx] = new Node();
            }

            if(i == word.length()-1){

                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }

    }

    public static void main(String[] args) {


    }
}