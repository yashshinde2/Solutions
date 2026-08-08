import java.util.*;

class BinaryTrees{

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

    static class BinaryTree{

        static int idx = -1;

        public static Node BuildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){

                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = BuildTree(nodes);
            newNode.right = BuildTree(nodes);

            return newNode;

        }

    }

    public static void preOrder(Node root){

        if(root == null){

            return;
        }

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public static void inOrder(Node root){

        if(root == null){

            return;
        }

        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static void postOrder(Node root){

        if(root == null){

            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    public static void levelOrder(Node root){

        if(root == null){

            return;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){

            Node currNode = q.remove();
            if(currNode == null){

                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countofNodes(Node root){

        if(root == null){

            return 0;
        }

        int leftCount = countofNodes(root.left);
        int rightCount = countofNodes(root.right);

        return leftCount + rightCount + 1;
    }

    public static int sumofNodes(Node root){

        if(root == null){

            return 0;
        }

        int leftSum = sumofNodes(root.left);
        int rightSum = sumofNodes(root.right);

        return leftSum + rightSum + root.data;
    }

    public static int heightofTree(Node root){

        if(root == null){

            return 0;
        }

        int leftHeight = heightofTree(root.left);
        int rightHeight = heightofTree(root.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static int diameterofTree(Node root){

        if(root == null){

            return 0;
        }

        int leftDiameter = diameterofTree(root.left);
        int rightDiameter = diameterofTree(root.right);
        int leftHeight = heightofTree(root.left);
        int rightHeight = heightofTree(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    static class TreeInfo{

        int height;
        int diameter;

        TreeInfo(int height, int diameter){

            this.height = height;
            this.diameter = diameter;
        }
    }

    public static TreeInfo diameterofTree2(Node root){

        if(root == null){

            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterofTree2(root.left);
        TreeInfo right = diameterofTree2(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height + right.height + 1;

        int myDiameter = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(myHeight, myDiameter);
        return myInfo;
    }


    public static void main(String[] args){

        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree bt = new BinaryTree();
        Node root = bt.BuildTree(nodes);
        // System.out.println(root.data);

        // preOrder(root);
        // inOrder(root);
        // postOrder(root);
        // levelOrder(root);
        // System.out.println(countofNodes(root));
        // System.out.println(sumofNodes(root));

        // System.out.println(heightofTree(root));
        System.out.println(diameterofTree(root));
        System.out.println(diameterofTree2(root).diameter);
    }
}