
import java.util.ArrayList;

class BST{

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val){

        if(root == null){
            root = new Node(val);
            return root;
        }

        if(root.data > val){
            // left subtree
            root.left = insert(root.left, val);
        }else{
            // right subtree
            root.right = insert(root.right, val);
        }

        return root;
    }

    public static void inOrder(Node root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){

        if(root == null){
            return false;
        }

        if(root.data == key){
            return true;
        }

        if(root.data > key){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val){

        if(root.data > val){
            root.left = delete(root.left, val);
        }else if(root.data < val){
            root.right = delete(root.right, val);
        }else{
            
            if(root.left == null && root.right == null){
                return null;
            }

            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }

    public static Node findInorderSuccessor(Node root){

        while(root.left != null){
            root = root.left;
        }

        return root;
    }

    public static void printInRange(Node root, int x, int y){

        if(root == null){
            return;
        }

        if(root.data >= x && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }else if(root.data < x){
            printInRange(root.right, x, y);
        }else{
            printInRange(root.left, x, y);
        }
    }

    public static void printPath(ArrayList<Integer> path){

        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "->");
        }
        System.out.println();
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){

        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        int[] values = {1,2,3,4,5,6,7};
        Node root = null;

        for(int val : values){
            root = insert(root, val);
        }

        inOrder(root);

        // System.out.println();
        // System.out.println(search(root, 5));

        // delete(root, 3);
        // System.out.println();
        // inOrder(root);

        // printInRange(root, 3, 6);

        printRoot2Leaf(root, new ArrayList<>());
    }
}