package BinaryTree;

public class Height {
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

    //Height of the tree
    public static int height(Node root){
        if(root == null){
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);
        
        return Math.max(lh,rh)+1; 
    }

    //Count of Nodes
    public static int count(Node root){
        if(root == null){
            return 0;
        }

        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount+rightCount+1;
    }

    //Sum of Nodes
    public static int sum(Node root){
        if(root == null){
            return 0;
        }

        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    } 

    //Diameter of tree
    // Brute Force Approach - TC = O(N^2)
    public static int Diameter2(Node root){
        if(root == null){
            return 0;
        }

        int leftDiam = Diameter2(root.left);
        int rightDiam = Diameter2(root.left);
        int lh = height(root.left);
        int rh = height(root.right);

        int selfDiam =lh +rh+1;

        return Math.max(selfDiam, Math.max(leftDiam, rightDiam));
    }

    // Optimized Approach - TC = O(N)
    static class Info{
        int diam;
        int ht;

        public Info(int diam,int ht){
            this.diam = diam;
            this.ht = ht;
        }
    }

    public static Info diameter(Node root){
        if(root == null){
            return new Info(0,0);
        }

        Info leftInfo = diameter(root.left);
        Info rightInfo = diameter(root.right);

        int diam =Math.max(Math.max(leftInfo.diam,rightInfo.diam) , leftInfo.ht + rightInfo.ht +1);
        int ht =Math.max(leftInfo.ht ,rightInfo.ht) + 1;

        return new Info(diam, ht);
    }

    //Kth level of Binary Tree
    public static void levelOrder(Node root,int level,int k){
        if(root == null){
            return;
        }

        if(level == k){
            System.out.print(root.data + " ");
            return;
        }
        levelOrder(root.left, level +1, k);
        levelOrder(root.right, level+1, k);
    }
    public static void main(String args[]){
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println("Height of the tree: " + height(root));
        System.out.println("count of the tree: " + count(root));
        System.out.println("Sum of the tree: " + sum(root));
        System.out.println("Diameter of the tree: " + Diameter2(root));
        System.out.println("Diameter of the tree: " + diameter(root).diam);
        System.out.println("height of the tree: " + diameter(root).ht);

        //Kth level of Binary Tree
        int k=3;
        levelOrder(root, 1, k);
    }
}
